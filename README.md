# Grade Calculator 📊

## Project Overview

The Grade Calculator is a modern, user-friendly desktop application developed with **JavaFX** that accurately calculates and tracks academic grades. This application uniquely supports both **cumulative (total points)** and **weighted** grading systems, providing a versatile tool for understanding academic performance.

This project demonstrates my proficiency in building robust and interactive desktop applications, highlighting key skills in UI/UX design, event-driven programming, and effective data management.

## Features ✨

The application now reads all assignment data from `assignment-grades.csv` and weighted category data from `category-weight.csv`. This provides a static way to calculate and display grades based on pre-defined data.

* **Weighted Grade Calculation:**
    * Reads assignment categories and their respective weight percentages from `category-weight.csv`.
    * Reads all individual assignment scores (earned points and possible points) from `assignment-grades.csv`.
    * The application processes this data to calculate and display the overall weighted grade.

* **Cumulative Grade Calculation:**
    * Reads all individual assignment scores (earned points / possible points) from `assignment-grades.csv`.
    * The application aggregates all scores to present a simple, overall cumulative percentage.

* **Intuitive User Experience:**
    * Clear prompts and instructional alerts guide users through the calculation process.
    * Interactive buttons and input fields ensure a smooth workflow.

* **Modular Design:**
    * Structured using FXML and Java controllers, promoting separation of concerns (UI layout vs. application logic) and enhancing maintainability.

* **Input Validation & Error Handling:**
    * Includes basic validation for numeric inputs, preventing common runtime errors from malformed data.

---

## Technical Highlights 💻

* **JavaFX:** Leveraged the JavaFX framework for building a rich and interactive graphical user interface, demonstrating expertise in modern Java desktop application development.
* **FXML:** Utilized FXML for declarative UI definition, allowing for cleaner separation of presentation from business logic and promoting rapid UI prototyping.
* **MVC Pattern:** Adhered to the Model-View-Controller (MVC) architectural pattern, enhancing code organization, testability, and scalability. Controllers manage user interactions and data flow, while FXML defines the views.
* **Data Handling:** The application now demonstrates proficiency in reading and parsing data from `.csv` files using `BufferedReader` and `FileReader` to perform grade calculations.
* **Event Handling:** Proficiently handled various user events (button clicks and text input) to drive application logic and UI updates.
* **CSS Styling:** Applied custom CSS to ensure a consistent and aesthetically pleasing visual design, demonstrating an understanding of styling JavaFX applications.

---

## Getting Started (VS Code) 🚀

To run this project on your local machine using VS Code:

### Prerequisites

* **Java Development Kit (JDK):** Version 11 or higher (e.g., OpenJDK 21).
* **Visual Studio Code (VS Code):**
* **Java Extension Pack for VS Code:** (Includes Language Support for Java™ by Red Hat, Debugger for Java, etc.)
* **JavaFX SDK:** Download the SDK from the [OpenJFX website](https://openjfx.io/openjfx-docs/#install-javafx). Choose the SDK compatible with your JDK version.

### Project Setup

1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-url>
    cd grade-calculator
    ```
2.  **Open in VS Code:**
    Open the `grade-calculator` folder in Visual Studio Code.

3.  **Configure JavaFX SDK in VS Code:**
    This is the most crucial step for running JavaFX projects in VS Code.
    * Go to `File > Preferences > Settings` (or `Code > Settings` on macOS).
    * Search for `Java: Java Home` and ensure it points to your JDK installation.
    * Search for `Java > Project: Referenced Libraries` or `java.project.referencedLibraries`.
    * Click "Add Item" and **add all the `.jar` files** from the `lib` directory of your downloaded JavaFX SDK. For example, if you unzipped JavaFX SDK to `/path/to/javafx-sdk-21`, you would add `/path/to/javafx-sdk-21/lib/*.jar`.
    * **Important:** You might need to manually edit your `settings.json` file for the workspace or user. It should look something like this (adjust path):
        ```json
        "java.project.referencedLibraries": [
            "lib/**/*.jar", // If you place JavaFX jars in a 'lib' folder inside your project
            "/path/to/javafx-sdk-21/lib/*.jar" // Or point directly to your SDK location
        ]
        ```

4.  **Create/Configure `launch.json` for Running:**
    * Go to the "Run and Debug" view (`Ctrl+Shift+D` or `Cmd+Shift+D`).
    * Click "create a launch.json file" (if one doesn't exist) and select "Java".
    * Modify the generated configuration for your `Main` class to include JavaFX VM arguments. Your `launch.json` (inside `.vscode` folder) should look similar to this:

    ```json
    {
        "version": "0.2.0",
        "configurations": [
            {
                "type": "java",
                "name": "Launch Grade Calculator",
                "request": "launch",
                "mainClass": "Main", // Ensure this is your main class with the start method
                "projectName": "grade-calculator", // Replace with your actual project name if different
                "vmArgs": "--module-path \"/path/to/javafx-sdk-21/lib\" --add-modules javafx.controls,javafx.fxml,javafx.graphics"
                // IMPORTANT: Replace "/path/to/javafx-sdk-21/lib" with the actual path to your JavaFX SDK lib directory.
                // You might also need to add 'javafx.base' if you get errors.
            }
        ]
    }
    ```

### Running the Application

1.  Once your `launch.json` is configured, simply go to the "Run and Debug" view (`Ctrl+Shift+D`).
2.  Select the "Launch Grade Calculator" configuration from the dropdown.
3.  Click the green "Start Debugging" arrow.

The application window should now appear!

---

## How to Use 📖

The application's controllers now read from pre-defined `.csv` files to perform calculations.

1.  **Start Screen:** Click "Start Calculating Your Grade".
2.  **Class Information:**
    * The application will automatically read and process data from `assignment-grades.csv` and `category-weight.csv` to display the calculated grades.
3.  **Cumulative Grade:**
    * The application reads all "earned-points" and "possible-points" from `assignment-grades.csv`.
    * It then aggregates these values to display the overall cumulative percentage.
4.  **Weighted Grade:**
    * The application reads the category weights from `category-weight.csv`.
    * It then reads all assignments from `assignment-grades.csv`.
    * The total points for each