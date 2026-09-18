# Práctica 01 – Recomposición en Jetpack Compose

## Integrantes

| Nombre |
|--------|
| Huayhua Hillpa Yourdyy Yossimar |
|  |

---

## ¿Qué hace la app?

Simula una pantalla de **compra de entradas de cine**. El usuario puede:

- Seleccionar la cantidad de entradas (botones `+` / `−`)
- Agregar extras: canchita y bebida (checkboxes)
- Aplicar un cupón de descuento (checkbox)
- Ver el subtotal, descuento y total actualizados en tiempo real

---

## Componentes principales

| Componente | Razón de uso |
|---|---|
| `ComponentActivity` + `setContent` | Punto de entrada de la Activity; monta el árbol Compose |
| `@Composable` | Marca funciones que generan UI declarativa |
| `remember` + `mutableStateOf` | Mantiene el estado local (`cantidad`, checkboxes) entre recomposiciones |
| `Column` / `Row` | Layout vertical y horizontal de los elementos |
| `Text` | Muestra etiquetas, valores calculados y el título |
| `OutlinedIconButton` | Botones `+` / `−` para modificar la cantidad |
| `Checkbox` | Selección de extras y cupón |
| `HorizontalDivider` | Separador visual entre secciones |
| `Button` | Botón final de acción "Comprar" |
| `MaterialTheme.typography` | Estilos de texto consistentes (headline, title, etc.) |

La función `LabeledCheckbox` es un composable auxiliar que agrupa un `Checkbox` con su `Text` para reutilizarse en extras y cupón.

---

## Guía de uso rápida

> Requiere Android SDK y Gradle configurados.

**Compilar APK de debug**
```bash
./gradlew assembleDebug
```
El APK queda en `app/build/outputs/apk/debug/app-debug.apk`.

**Compilar e instalar en dispositivo/emulador conectado**
```bash
./gradlew installDebug
```
> Asegúrate de tener un dispositivo con depuración USB habilitada o un emulador corriendo antes de ejecutar este comando.

