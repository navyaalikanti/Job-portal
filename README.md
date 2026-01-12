==============================
JOB PORTAL WEB APPLICATION
==============================

1. INTRODUCTION
---------------
This project is a **Job Portal Web Application** developed using **JSP, JDBC, MySQL, and Apache Tomcat**.
It provides a **single platform** for **Recruiters** to post jobs and manage applications, and for
**Job Seekers** to search jobs, apply online, track application status, and manage their portfolio.

The application follows a **Client–Server Architecture** where:
- JSP pages act as the client interface
- Apache Tomcat acts as the web server
- MySQL is used for persistent data storage

--------------------------------------------------

2. SYSTEM ARCHITECTURE
----------------------
The system is based on a **client–server model**.

- Users interact with the system through **JSP pages** in a web browser
- Requests are processed by the **Apache Tomcat server**
- Server-side logic communicates with the **MySQL database using JDBC**
- **HttpSession** is used to manage user authentication and role-based access

--------------------------------------------------

3. USER ROLES
-------------
The application supports **two types of users**:

1. **Recruiter**
2. **Job Seeker**

Each user type has:
- Separate registration and login
- Role-specific dashboard
- Different functionalities and permissions

--------------------------------------------------

4. REGISTRATION AND AUTHENTICATION
----------------------------------
- Users can register either as a **Recruiter** or a **Job Seeker**
- Recruiter data is stored in the **recruiters** table
- Job seeker data is stored in the **job_seekers** table
- Login is performed using **email and password**
- On successful login:
  - Recruiters are redirected to the **Recruiter Dashboard**
  - Job Seekers are redirected to the **Job Seeker Dashboard**
- Logout ends the user session securely

--------------------------------------------------

5. RECRUITER MODULE LOGIC
-------------------------
After login, the recruiter is redirected to the **Recruiter Dashboard**.

Key functionalities include:

**Job Posting**
- Recruiters can post jobs with basic job details such as:
  - Job title
  - Job description
  - Requirements
  - Location
  - Salary range
  - Job type
- Recruiters can create a **customized application form**
- Up to **10 custom fields** can be added
- Custom fields include **field name and field type**
- Job data and custom fields are stored in the **jobs** table

**Application Management**
- Recruiters can view all jobs they have posted
- For each job, the number of applications received is displayed
- Recruiters can view applications for a specific job
- Application status can be updated as:
  - Pending (default)
  - Accepted
  - Rejected
  - Marked for Review
- Status updates are stored in the **job_applications** table

**Company Profile Management**
- Recruiters can create and update company profile details
- Company information and address data are stored in separate tables

--------------------------------------------------

6. JOB SEEKER MODULE LOGIC
--------------------------
After login, job seekers are redirected to the **Job Seeker Dashboard**.

Key functionalities include:

**Job Search and Application**
- Job seekers can view all available job postings
- Search functionality is provided for specific jobs
- Job seekers can view company profiles before applying
- Application forms are **dynamically generated** based on recruiter-defined fields
- Submitted applications are stored with status set to **Pending**

**Application Tracking**
- Job seekers can track all applied jobs
- Current application status is displayed for each job

**Portfolio Management**
- Job seekers can manage their professional portfolio
- Portfolio includes:
  - Skills
  - Projects
  - Experience
  - Social media links
- Portfolio data is stored across multiple related tables

--------------------------------------------------

7. APPLICATION TRACKING SYSTEM
-------------------------------
- Recruiters can filter applications by status:
  - All
  - Accepted
  - Rejected
  - Pending
  - Marked for Review
- Job seekers can view real-time application status updates
- All status changes are reflected directly from the database

--------------------------------------------------

8. SETTINGS
-----------
- Users can change their account password
- User preferences such as theme mode can be managed

--------------------------------------------------

9. CONCLUSION
-------------
This Job Portal Web Application implements a **complete recruitment workflow**.
The project demonstrates:
- Server-side development using **JSP**
- Database connectivity using **JDBC**
- Secure session management
- Role-based access control
- Dynamic form handling and application tracking
