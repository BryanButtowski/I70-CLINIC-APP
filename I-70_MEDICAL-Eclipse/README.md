# I-70_MEDICAL

A Java Swing-based medical records management system built using Maven. It helps manage patient records, insurance details, and emergency contact information in a user-friendly interface.

---

## ⓘ Project Details

- **Project Name**: I-70_MEDICAL  
- **Language**: Java  
- **Java Version**: 21  
- **Build Tool**: Maven  
- **Packaging**: JAR (executable)  
- **Main Class**: `backend.RunApp`  

---

## ⓘ Dependencies

This project uses the following libraries (downloaded automatically by Maven):

- **MySQL Connector** `8.0.33` – Database connection  
- **MigLayout** `11.1` – Layout manager for Swing  
- **jCalendar** `1.4` – Date picker for Swing  

All dependencies are managed in `pom.xml`.

---

## ⓘ Prerequisites

Please make sure the following are installed:

- [Java JDK 21+](https://jdk.java.net/)
- [Apache Maven 3.6+](https://maven.apache.org/download.cgi)
- MySQL Server (if using a database)

How to Install Maven (Windows)

1. Download from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
2. Extract the ZIP (e.g., `apache-maven-3.9.x-bin.zip`) to:
3. Set environment variables:
- `MAVEN_HOME` → `C:\Program Files\Apache\Maven\apache-maven-3.9.x`
- Add to `Path`: `C:\Program Files\Apache\Maven\apache-maven-3.9.x\bin`
4. Check in CMD: `cmd` → `mvn -version` → `mvn clean package`

target/I-70_MEDICAL-1.0-SNAPSHOT-jar-with-dependencies.jar

---

## ⓘ Database Setup

To make the app work properly, you must import the required database tables into your MySQL server. These 
are located at: I-70_MEDICAL-Eclipse\src\main\resources\Database_Table

You can import the SQL files using MySQL Workbench, phpMyAdmin, or the command line.

**Option 1:** Using MySQL Workbench

1. Open MySQL Workbench and connect to your server.
2. Go to Server > Data Import. Under the import options, choose the folder that contains the table files. Then, select the target schema where the tables will be imported.
You can also create a new schema.
3. Click **Start Import**

**Option 2:** Using MySQL Command Line

1. Open a terminal or Command Prompt and log in:

   `mysql -u your_username -p`

2. Then in the MySQL shell:

   `CREATE DATABASE clinic_db;`

   `USE clinic_db;`

   `SOURCE path/to/db_schema_admin_credentials.sql;`

   `SOURCE path/to/db_schema_admin_billhandler_info.sql;`

   `SOURCE path/to/db_schema_hipaa_info.sql;`

   `SOURCE path/to/db_schema_insurance_name.sql;`

   `SOURCE path/to/db_schema_patient_info.sql;`

   `SOURCE path/to/db_schema_patient_insurance.sql;`

   `SOURCE path/to/db_schema_subscriber_info.sql;`

   Replace `path/to/` with the actual path to your `.sql` files.

To be able to access the data from database to app, you need to configure the credentials in the DatabaseConnection.java file:
1. Go to I-70_MEDICAL-Eclipse > src > main > java > database > DatabaseConnection.
2. Replace the inputted credentials in lines 11 and 12 with your own one.
3. Save the .java file.

---

## ⓘ To Run the Application
TIP: The app runs best in Eclipse IDE but other IDEs may do. 

**Using Command Line**
1. Open a terminal and navigate to the project directory: `cd path\to\I-70_MEDICAL-Eclipse`
2. Then run:

   `mvn compile`

   `mvn exec:java -Dexec.mainClass="backend.RunApp"`

**Using Eclipse**
1. Open Eclipse and import the project: `File > Import > Existing Maven Projects`
2. Navigate to the folder containing the project (I-70_MEDICAL-Eclipse) and click Finish.
3. Once imported, build the project with Maven. Right-click the project in the Project Explorer
4. Go to Run As > Maven install (or Maven build... → enter clean install)
5. Wait for Maven to download dependencies and compile the project
6. After the build is successful, locate the file with the main() method (e.g., RunApp.java)
7. Right-click the file → Run As > Java Application

Thank you, and all the best! 