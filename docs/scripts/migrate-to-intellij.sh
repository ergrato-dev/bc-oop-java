#!/bin/bash

# Script para migrar estructura de ejercicios a estructura IntelliJ recomendada
# Bootcamp POO Java - Semana 00

echo "🚀 Migración de Estructura para IntelliJ IDEA"
echo "=============================================="
echo ""

# Variables
SEMANA_DIR="$(pwd)/bootcamp/semana-00"
SRC_BASE="src/main/java/com/sena/bootcamp/semana00"

# Verificar que estamos en el directorio correcto
if [ ! -d "$SEMANA_DIR" ]; then
    echo "❌ Error: No se encuentra el directorio bootcamp/semana-00"
    echo "   Ejecuta este script desde la raíz del proyecto"
    exit 1
fi

echo "📁 Directorio de trabajo: $SEMANA_DIR"
echo ""

# Preguntar al usuario
read -p "¿Deseas crear la estructura recomendada de IntelliJ? (s/n): " -n 1 -r
echo ""

if [[ ! $REPLY =~ ^[Ss]$ ]]; then
    echo "Operación cancelada."
    exit 0
fi

echo ""
echo "📦 Creando estructura de directorios..."

# Crear estructura base
mkdir -p "$SEMANA_DIR/$SRC_BASE"
mkdir -p "$SEMANA_DIR/out"

# Crear paquetes para cada ejercicio
for i in {1..6}; do
    EJERCICIO_NUM=$(printf "%02d" $i)
    mkdir -p "$SEMANA_DIR/$SRC_BASE/ejercicio$EJERCICIO_NUM"
    echo "   ✓ Creado: $SRC_BASE/ejercicio$EJERCICIO_NUM"
done

echo ""
echo "📋 Copiando archivos Java..."

# Función para copiar archivos y agregar package
copy_with_package() {
    local source_file=$1
    local dest_dir=$2
    local package_name=$3
    local filename=$(basename "$source_file")
    
    # Crear archivo temporal con package
    {
        echo "package $package_name;"
        echo ""
        # Saltar línea de package si ya existe
        grep -v "^package " "$source_file"
    } > "$dest_dir/$filename"
    
    echo "   ✓ Copiado: $filename → $package_name"
}

# Ejercicio 01
if [ -d "$SEMANA_DIR/2-practica/ejercicio-01-hola-mundo" ]; then
    DEST="$SEMANA_DIR/$SRC_BASE/ejercicio01"
    PKG="com.sena.bootcamp.semana00.ejercicio01"
    for file in "$SEMANA_DIR/2-practica/ejercicio-01-hola-mundo"/*.java; do
        [ -f "$file" ] && copy_with_package "$file" "$DEST" "$PKG"
    done
fi

# Ejercicio 02
if [ -d "$SEMANA_DIR/2-practica/ejercicio-02-variables" ]; then
    DEST="$SEMANA_DIR/$SRC_BASE/ejercicio02"
    PKG="com.sena.bootcamp.semana00.ejercicio02"
    for file in "$SEMANA_DIR/2-practica/ejercicio-02-variables"/*.java; do
        [ -f "$file" ] && copy_with_package "$file" "$DEST" "$PKG"
    done
fi

# Ejercicio 03
if [ -d "$SEMANA_DIR/2-practica/ejercicio-03-control" ]; then
    DEST="$SEMANA_DIR/$SRC_BASE/ejercicio03"
    PKG="com.sena.bootcamp.semana00.ejercicio03"
    for file in "$SEMANA_DIR/2-practica/ejercicio-03-control"/*.java; do
        [ -f "$file" ] && copy_with_package "$file" "$DEST" "$PKG"
    done
fi

# Ejercicio 04
if [ -d "$SEMANA_DIR/2-practica/ejercicio-04-arrays" ]; then
    DEST="$SEMANA_DIR/$SRC_BASE/ejercicio04"
    PKG="com.sena.bootcamp.semana00.ejercicio04"
    for file in "$SEMANA_DIR/2-practica/ejercicio-04-arrays"/*.java; do
        [ -f "$file" ] && copy_with_package "$file" "$DEST" "$PKG"
    done
fi

# Ejercicio 05
if [ -d "$SEMANA_DIR/2-practica/ejercicio-05-metodos" ]; then
    DEST="$SEMANA_DIR/$SRC_BASE/ejercicio05"
    PKG="com.sena.bootcamp.semana00.ejercicio05"
    for file in "$SEMANA_DIR/2-practica/ejercicio-05-metodos"/*.java; do
        [ -f "$file" ] && copy_with_package "$file" "$DEST" "$PKG"
    done
fi

# Ejercicio 06
if [ -d "$SEMANA_DIR/2-practica/ejercicio-06-integrador" ]; then
    DEST="$SEMANA_DIR/$SRC_BASE/ejercicio06"
    PKG="com.sena.bootcamp.semana00.ejercicio06"
    for file in "$SEMANA_DIR/2-practica/ejercicio-06-integrador"/*.java; do
        [ -f "$file" ] && copy_with_package "$file" "$DEST" "$PKG"
    done
fi

echo ""
echo "📝 Creando archivo .iml para el módulo..."

cat > "$SEMANA_DIR/semana-00.iml" << 'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4">
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src/main/java" isTestSource="false" />
      <excludeFolder url="file://$MODULE_DIR$/out" />
      <excludeFolder url="file://$MODULE_DIR$/2-practica" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
  </component>
</module>
EOF

echo "   ✓ Creado: semana-00.iml"

echo ""
echo "✅ Migración completada!"
echo ""
echo "📖 Próximos pasos:"
echo "   1. Abre IntelliJ IDEA"
echo "   2. File → Open → Selecciona el directorio oop_java/"
echo "   3. Espera que IntelliJ indexe el proyecto"
echo "   4. Verifica que 'src/main/java' esté marcado como Sources Root (carpeta azul)"
echo "   5. Ejecuta cualquier clase con método main()"
echo ""
echo "📂 Estructura creada:"
echo "   $SEMANA_DIR/"
echo "   ├── src/main/java/com/sena/bootcamp/semana00/"
echo "   │   ├── ejercicio01/"
echo "   │   ├── ejercicio02/"
echo "   │   ├── ejercicio03/"
echo "   │   ├── ejercicio04/"
echo "   │   ├── ejercicio05/"
echo "   │   └── ejercicio06/"
echo "   ├── out/"
echo "   └── semana-00.iml"
echo ""
echo "ℹ️  Los archivos originales en 2-practica/ se mantienen como referencia"
echo ""
