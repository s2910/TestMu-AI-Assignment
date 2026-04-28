#  Amazon Automation Testing Project

## Overview
This project automates the Amazon website using Selenium WebDriver and TestNG.

It performs the following actions:
- Search for a product (e.g., iPhone, Samsung Galaxy)
- Select the first product from search results
- Extract product price
- Add product to cart

---

##  Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver

---

## 📁 Project Structure
```
TestMu-AI-Assignment/
│── src/
│   ├── Pages/                 # Page Object Model classes
│   │   ├── BaseTest.java      # Driver setup
│   │   ├── AmazonPage.java
│   │
│   ├── TestCase/
│   │   ├── AmazonTest.java    # Test classes
│
│── testng.xml                 # TestNG configuration
│── pom.xml                    # Maven dependencies
│── README.md                  # Project documentation
```

---

## ⚙️ Prerequisites
Make sure you have installed:
- Java (JDK 8 or above)
- Maven
- Chrome browser

---

##  Setup Instructions

Clone the repository:
```
git clone https://github.com/s2910/TestMu-AI-Assignment.git
```

Navigate to project folder:
```
cd TestMu-AI-Assignment
```

Install dependencies:
```
mvn clean install
```

---

##  How to Run Tests

Run using TestNG XML:
```
mvn test
```

OR

Run directly:
- Right-click on `testng.xml`
- Click **Run**

---

##  Parallel Execution

This project supports parallel execution using TestNG.

To configure:

Open `testng.xml` and set:
```
<suite parallel="methods" thread-count="2">
```

---

##  Test Cases

| Test Case         | Description                                      |
|------------------|--------------------------------------------------|
| iPhoneTestCase   | Searches for iPhone and adds to cart             |
| galaxyTestCase   | Searches for Samsung Galaxy and adds to cart     |

---

##  Features
- Page Object Model (POM) design
- Parallel test execution
- Dynamic element handling
- Clean and reusable code

---

##  Notes
- Amazon UI changes frequently, so locators may need updates
- Ensure ChromeDriver version matches your Chrome browser

---

##  Author
**Sewank Nande**
