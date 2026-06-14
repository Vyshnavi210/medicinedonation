Online Medicine Donation System

Project Overview

The Online Medicine Donation System is a web-based application developed using Spring Boot, Thymeleaf, MySQL, HTML, CSS, and Bootstrap.

The system provides a platform where members can donate unused medicines to NGOs. NGOs can claim approved medicines and distribute them to needy people. The Admin manages users, NGOs, and medicine approvals.

Problem Statement

Many people have unused medicines that remain unused until expiry. At the same time, many poor and needy people cannot afford medicines. This system helps connect medicine donors with NGOs, ensuring proper utilization of medicines and reducing wastage.

Features

Member Module

* Member Registration
* Member Login
* Donate Medicines
* View Donation Records
* Change Password

NGO Module

* NGO Registration
* NGO Login
* View Available Medicines
* Claim Approved Medicines
* Stock Management

Admin Module

* Admin Login
* Manage Members
* Manage NGOs
* Approve Medicine Donations
* Monitor Donation Status
* Generate Reports

Workflow

Member → Donate Medicine → Admin Approval → NGO Claim → Medicine Distribution

Medicine Status Flow

* PENDING
* APPROVED
* CLAIMED

Technology Stack

Frontend

* HTML
* CSS
* Bootstrap
* Thymeleaf

Backend

* Java
* Spring Boot

Database

* MySQL

Build Tool

* Maven

Software Requirements

* Java 21+
* Spring Boot 3.x
* MySQL
* Maven
* VS Code / IntelliJ IDEA

Hardware Requirements

* Intel i3 or above
* 4GB RAM or above
* 100GB Storage

Database Tables

Member

* id
* name
* email
* phone
* password
* status

NGO

* id
* ngoName
* email
* password

Medicine

* id
* medicineName
* quantity
* expiryDate
* description
* donationDate
* status
* memberId
* claimedByNgo
* claimedDate

Future Enhancements

* Automatic expiry validation
* Email notifications
* Medicine search functionality
* Analytics dashboard
* Online appointment scheduling

Developed By

Galam Guru Vyshnavi
