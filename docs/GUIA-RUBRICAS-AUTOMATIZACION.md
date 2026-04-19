# 📊 Rúbricas de Evaluación Automatizada - Bootcamp POO Java

## 📁 Estructura de Archivos

Cada semana del bootcamp tiene 3 formatos de rúbrica:

```
bootcamp/
├── semana-00/
│   ├── RUBRICA_EVALUACION.md          # Formato legible para estudiantes
│   ├── rubrica_evaluacion.json        # Para scripts de automatización
│   └── rubrica_evaluacion.yaml        # Formato alternativo
├── semana-01/
│   ├── RUBRICA_EVALUACION.md
│   ├── rubrica_evaluacion.json
│   └── rubrica_evaluacion.yaml
├── semana-02/
│   ├── RUBRICA_EVALUACION.md
│   ├── rubrica_evaluacion.json
│   └── rubrica_evaluacion.yaml
└── semana-03/
    ├── RUBRICA_EVALUACION.md
    ├── rubrica_evaluacion.json
    └── rubrica_evaluacion.yaml
```

---

## 🎯 Propósito de los Archivos

### 📄 `RUBRICA_EVALUACION.md`
- **Formato:** Markdown legible
- **Audiencia:** Estudiantes e instructores
- **Uso:** Consulta manual, guía de aprendizaje
- **Contenido:** Rúbricas detalladas con tablas y descripciones

### 🔧 `rubrica_evaluacion.json`
- **Formato:** JSON estructurado
- **Audiencia:** Scripts de automatización
- **Uso:** Entrada para scripts Python que evalúan repositorios
- **Contenido:** Criterios de evaluación, patrones de validación, configuración de API

### 📋 `rubrica_evaluacion.yaml`
- **Formato:** YAML legible y estructurado
- **Audiencia:** Scripts de automatización (más legible que JSON)
- **Uso:** Alternativa a JSON, fácil de editar manualmente
- **Contenido:** Misma información que JSON pero más legible

---

## 🤖 Uso con Scripts de Python + Claude API

### Estructura General de Datos

Cada archivo JSON/YAML contiene:

```json
{
  "semana": "01",
  "titulo": "Introducción al Paradigma Orientado a Objetos",
  "descripcion": "...",
  "nota_minima_aprobatoria": 3.0,
  "distribucion_evaluacion": {
    "conocimiento": {"peso": 30},
    "desempeno": {"peso": 40},
    "producto": {"peso": 30}
  },
  "evidencias": {
    "conocimiento": [...],
    "desempeno": [...],
    "producto": [...]
  },
  "configuracion_script_automatizacion": {
    "lenguaje": "python",
    "api": "claude",
    "prompts_claude": {...},
    "validaciones": {...}
  }
}
```

---

## 🐍 Integración con Python

### Ejemplo de Carga de Rúbrica

```python
import json
import yaml
from pathlib import Path

# Opción 1: Cargar JSON
def load_rubric_json(semana: str):
    rubric_path = Path(f"bootcamp/semana-{semana}/rubrica_evaluacion.json")
    with open(rubric_path, 'r', encoding='utf-8') as f:
        return json.load(f)

# Opción 2: Cargar YAML (más legible)
def load_rubric_yaml(semana: str):
    rubric_path = Path(f"bootcamp/semana-{semana}/rubrica_evaluacion.yaml")
    with open(rubric_path, 'r', encoding='utf-8') as f:
        return yaml.safe_load(f)

# Uso
rubrica = load_rubric_json("01")
print(f"Evaluando: {rubrica['titulo']}")
```

### Ejemplo de Validación Automatizada

```python
import re
from typing import Dict, List

class ValidadorCodigo:
    def __init__(self, rubrica: Dict):
        self.rubrica = rubrica
    
    def validar_ejercicio(self, codigo: str, ejercicio_id: str) -> Dict:
        """
        Valida código contra criterios de un ejercicio específico
        """
        ejercicio = self._buscar_ejercicio(ejercicio_id)
        validacion = ejercicio.get('validacion_automatica', {})
        
        resultados = {
            'compilacion': self._verificar_compilacion(codigo),
            'clases': self._verificar_clases(codigo, validacion),
            'metodos': self._verificar_metodos(codigo, validacion),
            'patrones': self._verificar_patrones(codigo, validacion)
        }
        
        return resultados
    
    def _verificar_patrones(self, codigo: str, validacion: Dict) -> bool:
        """Verifica patrones regex definidos en la rúbrica"""
        if 'patron_codigo' in validacion:
            patron = validacion['patron_codigo']
            return bool(re.search(patron, codigo))
        return True
    
    def _verificar_clases(self, codigo: str, validacion: Dict) -> List[str]:
        """Extrae clases encontradas en el código"""
        patron_clase = r'class\s+(\w+)'
        return re.findall(patron_clase, codigo)
```

### Ejemplo con Claude API

```python
import anthropic
import os

class EvaluadorConClaude:
    def __init__(self, rubrica: Dict):
        self.rubrica = rubrica
        self.client = anthropic.Anthropic(
            api_key=os.environ.get("CLAUDE_API_KEY")
        )
    
    def evaluar_codigo(self, codigo: str, tipo_evidencia: str) -> Dict:
        """
        Evalúa código usando Claude según prompts de la rúbrica
        """
        config = self.rubrica['configuracion_script_automatizacion']
        prompts = config.get('prompts_claude', {})
        
        # Seleccionar prompt según tipo de evidencia
        prompt_key = f"evaluar_{tipo_evidencia}"
        prompt_template = prompts.get(prompt_key, "")
        
        # Construir prompt completo
        prompt_completo = f"""
{prompt_template}

Código a evaluar:
```java
{codigo}
```

Rúbrica:
{self._extraer_criterios_relevantes(tipo_evidencia)}

Proporciona:
1. Puntuación (0-5.0)
2. Fortalezas identificadas
3. Áreas de mejora
4. Comentarios específicos
"""
        
        # Llamar a Claude
        message = self.client.messages.create(
            model="claude-3-5-sonnet-20241022",
            max_tokens=2000,
            messages=[
                {"role": "user", "content": prompt_completo}
            ]
        )
        
        return self._parsear_respuesta(message.content)
    
    def _extraer_criterios_relevantes(self, tipo: str) -> str:
        """Extrae criterios de evaluación relevantes de la rúbrica"""
        evidencias = self.rubrica['evidencias'].get(tipo, [])
        return json.dumps(evidencias, indent=2, ensure_ascii=False)
```

---

## 🔍 Validaciones Automatizables

### 1. Validaciones Estáticas (Sin Claude)

Estas se pueden hacer con análisis de código:

```python
validaciones = {
    "debe_compilar": True,                    # javac
    "debe_ejecutar": True,                    # java
    "minimo_clases": 2,                       # regex
    "minimo_metodos": 3,                      # regex
    "minimo_atributos": 4,                    # regex
    "patron_getter": "public.*get[A-Z].*",   # regex
    "patron_setter": "public void set.*",     # regex
    "todos_privados": True,                   # regex
    "uso_arrays": True,                       # regex
    "patron_scanner": "Scanner|import.*Scanner" # regex
}
```

### 2. Validaciones con Claude API

Estas requieren análisis semántico:

```python
prompts_claude = {
    "evaluar_encapsulacion": "Analiza si aplica correctamente encapsulación...",
    "evaluar_modelado": "Evalúa si las clases modelan apropiadamente el dominio...",
    "evaluar_codigo": "Analiza calidad, sintaxis y uso de POO...",
    "evaluar_documentacion": "Revisa comentarios Javadoc y README..."
}
```

---

## 📊 Estructura de Respuesta del Script

```json
{
  "estudiante": "Juan Pérez",
  "semana": "01",
  "repositorio": "https://github.com/juanperez/semana-01",
  "fecha_evaluacion": "2025-10-21T20:30:00",
  "resultados": {
    "conocimiento": {
      "puntuacion": 4.2,
      "peso": 30,
      "evidencias": [
        {
          "id": "C1",
          "nombre": "Cuestionario Teórico",
          "puntuacion": 4.5,
          "comentarios": "Excelente comprensión de conceptos..."
        }
      ]
    },
    "desempeno": {
      "puntuacion": 4.0,
      "peso": 40,
      "evidencias": [...]
    },
    "producto": {
      "puntuacion": 3.8,
      "peso": 30,
      "evidencias": [...]
    }
  },
  "nota_final": 4.0,
  "aprobado": true,
  "feedback_general": "...",
  "validaciones_automaticas": {
    "compilacion": true,
    "ejecucion": true,
    "estilo_codigo": true,
    "cobertura_requisitos": 85
  }
}
```

---

## 🚀 Flujo de Evaluación Recomendado

```
1. Clonar repositorio del estudiante
   └─> git clone <repo_url>

2. Cargar rúbrica de la semana
   └─> rubrica = load_rubric_json("01")

3. Validaciones estáticas
   ├─> Compilar código (javac)
   ├─> Ejecutar pruebas (java)
   ├─> Verificar patrones regex
   └─> Análisis estático (checkstyle, opcional)

4. Validaciones con Claude API
   ├─> Evaluar calidad de código
   ├─> Analizar encapsulación
   ├─> Revisar documentación
   └─> Evaluar modelado del dominio

5. Calcular puntuación final
   └─> Aplicar pesos de distribución_evaluacion

6. Generar reporte
   └─> JSON, PDF o HTML con resultados
```

---

## 🛠️ Herramientas Complementarias

### Compilación Java

```python
import subprocess

def compilar_java(archivo: str) -> tuple[bool, str]:
    """Compila archivo Java y retorna (éxito, mensaje)"""
    resultado = subprocess.run(
        ['javac', archivo],
        capture_output=True,
        text=True
    )
    return resultado.returncode == 0, resultado.stderr

def ejecutar_java(clase: str) -> tuple[bool, str]:
    """Ejecuta clase Java y retorna (éxito, output)"""
    resultado = subprocess.run(
        ['java', clase],
        capture_output=True,
        text=True,
        timeout=10
    )
    return resultado.returncode == 0, resultado.stdout
```

### Análisis de Código

```python
import javalang

def analizar_estructura(codigo: str) -> Dict:
    """Analiza estructura del código Java"""
    try:
        tree = javalang.parse.parse(codigo)
        
        clases = [c.name for c in tree.types if isinstance(c, javalang.tree.ClassDeclaration)]
        metodos = []
        atributos = []
        
        for path, node in tree:
            if isinstance(node, javalang.tree.MethodDeclaration):
                metodos.append(node.name)
            elif isinstance(node, javalang.tree.FieldDeclaration):
                for declarator in node.declarators:
                    atributos.append(declarator.name)
        
        return {
            'clases': clases,
            'metodos': metodos,
            'atributos': atributos,
            'num_clases': len(clases),
            'num_metodos': len(metodos),
            'num_atributos': len(atributos)
        }
    except Exception as e:
        return {'error': str(e)}
```

---

## 📝 Ejemplo Completo de Script

Ver archivo: `_scripts/evaluador_automatico.py` (próximamente)

Características:
- ✅ Carga rúbricas JSON/YAML
- ✅ Clona repositorios de GitHub
- ✅ Compila y ejecuta código Java
- ✅ Valida con patrones regex
- ✅ Evalúa con Claude API
- ✅ Genera reportes detallados
- ✅ Envía feedback por email/GitHub Issues

---

## 🔐 Variables de Entorno Requeridas

```bash
# .env
CLAUDE_API_KEY=sk-ant-api03-...
GITHUB_TOKEN=ghp_...
JAVA_HOME=/usr/lib/jvm/java-17-openjdk
```

---

## 📦 Dependencias Python

```txt
# requirements.txt
anthropic>=0.25.0
pyyaml>=6.0
javalang>=0.13.0
gitpython>=3.1.0
python-dotenv>=1.0.0
```

---

## ⚠️ Consideraciones Importantes

1. **Privacidad**: Nunca incluir credenciales en los archivos de rúbrica
2. **Costos API**: Claude API tiene costos por token, monitorear uso
3. **Timeouts**: Establecer timeouts para compilación/ejecución (30-60s)
4. **Sandbox**: Ejecutar código estudiantil en entorno aislado
5. **Feedback**: Generar retroalimentación constructiva, no solo puntuaciones

---

## 📞 Soporte

Para dudas sobre las rúbricas o el sistema de evaluación:
- Revisar documentación en `docs/`
- Consultar con instructor del bootcamp
- Abrir issue en el repositorio

---

**Última actualización:** 21 de octubre de 2025  
**Versión:** 1.0.0  
**Bootcamp:** POO Java - SENA 2025
