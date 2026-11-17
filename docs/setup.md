# Preparar el entorno

Necesitas cuatro cosas: un JDK 25, Git, un editor y una terminal. Maven **no** se instala: cada proyecto trae su Maven Wrapper (`./mvnw`), que descarga la versión fijada la primera vez.

En Windows, trabaja dentro de **WSL2 con Ubuntu** y usa siempre su terminal: todos los comandos del bootcamp son de Linux.

## 1. JDK 25 con SDKMAN

[SDKMAN](https://sdkman.io/install/) instala y cambia versiones de Java sin tocar el sistema:

```bash
sudo apt update && sudo apt install -y zip unzip curl
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 25.0.5-tem
java -version
```

Salida esperada (la primera línea):

```
openjdk version "25.0.5" 2026-10-20 LTS
```

En macOS los mismos comandos funcionan en la terminal (sin la línea de `apt`).

## 2. Git

```bash
sudo apt install -y git
git config --global user.name "Tu Nombre"
git config --global user.email "tu-correo@ejemplo.com"
git config --global init.defaultBranch main
```

Para subir a GitHub con clave SSH, sigue `bc-git-github`.

## 3. Editor

**VS Code** con la extensión [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (en WSL2, instálala con VS Code conectado a WSL). IntelliJ IDEA Community también sirve: abre la carpeta del proyecto y detecta el `pom.xml`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `sdk: command not found` | Abre otra terminal o ejecuta `source "$HOME/.sdkman/bin/sdkman-init.sh"` |
| `java -version` muestra 17 o 21 | `sdk default java 25.0.5-tem` y abre otra terminal |
| `./mvnw: Permission denied` | `chmod +x mvnw` |
| `./mvnw` falla con `JAVA_HOME is not defined correctly` | `echo $JAVA_HOME` debe apuntar a `~/.sdkman/candidates/java/current`; si no, vuelve a abrir la terminal |
| VS Code no reconoce las clases | Paleta de comandos → `Java: Clean Java Language Server Workspace` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Inicio del bootcamp](../README.md) | **Preparar el entorno** | [Versiones del stack](stack-versions.md) |

← [Volver al inicio del bootcamp](../README.md)
