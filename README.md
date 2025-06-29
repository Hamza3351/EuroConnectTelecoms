# EuroConnectTelecoms 🚉📡

A **JavaFX + Kotlin + Scala** desktop application that computes and visualizes the **Minimum Spanning Tree (MST)** from a list of cities and distances using **Kruskal’s Algorithm**.

---

## 💡 Project Overview

EuroConnectTelecoms simulates the process of connecting European cities with minimum cost using advanced graph algorithms.

### 🔧 Technologies Used:
- **Kotlin** (OO + Functional paradigms)
- **Scala** (OO + Functional paradigms)
- **JavaFX** (Graphical User Interface)
- **Maven** (Project build and dependency management)
- **FXML** (UI markup)

---

## 📁 Features

✅ Load a CSV file with city-to-city distances  
✅ Visualize a fully connected graph  
✅ Select **Language** (Kotlin / Scala)  
✅ Choose **Paradigm** (Object-Oriented / Functional)  
✅ Compute and display the **Minimum Spanning Tree (MST)**  
✅ Dynamic graph rendering with cities, edges, and weights  
✅ Clean and responsive UI with JavaFX

---

## 📷 Screenshots

| Full Graph View | MST View |
|-----------------|-----------|
| ![Full Graph](https://github.com/Hamza3351/EuroConnectTelecoms/blob/master/Screenshots/BeforeRunningMST.PNG) | ![MST View](https://github.com/Hamza3351/EuroConnectTelecoms/blob/master/Screenshots/AfterRunningMST.PNG) |

---

## 📂 CSV Input Format

The app accepts `.csv` files with the following structure:

```csv
City1,City2,Distance
Paris,Berlin,450
Berlin,Rome,600
Paris,Rome,700
...
```

## 🚀 How to Run
1. Clone the Repository
   ```bash
   git clone https://github.com/yourusername/EuroConnectTelecoms.git
   cd EuroConnectTelecoms
   ```
2. Open in IntelliJ
   - Open the project as a Maven project.
   - Ensure Java 21 (or compatible) is set as your SDK.
3. Run the Application
   - Right-click MainApplication.kt > Run
   - Or use the Run button in IntelliJ.

## 🧠 Algorithms Implemented
- Kruskal’s MST Algorithm
- OO and Functional paradigms in both Kotlin and Scala
- Scala interop with Kotlin through Java-compatible wrappers

## 🧪 Sample Data
Check the `sample_data/` folder for ready-to-test `.csv` files.

## 📦 Project Structure
```
src/
├── main/
│   ├── kotlin/
│   │   └── com.example.euroconnecttelecoms/
│   │       ├── CsvLoader.kt
│   │       ├── Edge.kt
│   │       ├── KotlinMST.kt
│   │       ├── KotlinMST_Functional.kt
│   │       ├── KruskalMST.kt
│   │       ├── MainApplication.kt
│   │       └── MainController.kt
│   ├── resources/
│   │   └── com.example.euroconnecttelecoms/
│   │       └── main-view.fxml
│   ├── scala/
│   │   └── com.example.euroconnecttelecoms.ScalaMST/
│   │       ├── EdgeScala.scala
│   │       ├── ScalaMST.scala
│   │       ├── ScalaMSTFunctional.scala
│   │       └── ScalaMSTOO.scala
```
---
