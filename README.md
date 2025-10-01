# EI_CODING_ASSESSMENT (KRUTHIGA T B)

# Exercise 1: Design Patterns Implementation

## *Behavioural Patterns*

## Observer Pattern - Stock Trading System
**StockObserver.java**: Interface that defines the update method for receiving stock updates.

**StockTrader.java**: Concrete observer that receives and displays stock price notifications.

**StockMarket.java**: Subject that maintains list of observers and notifies them of stock changes.

**Stock.java**: Represents stock data with symbol and price.

**StockTradingApp.java**: Main application that demonstrates the Observer pattern with user interaction for adding traders and updating stock prices.

<img width="348" height="136" alt="Screenshot 2025-10-01 221019" src="https://github.com/user-attachments/assets/62f6dc6b-adf6-411f-be03-d9922f7bdfff" /><br>
<img width="390" height="74" alt="Screenshot 2025-10-01 221025" src="https://github.com/user-attachments/assets/06983393-3db6-448c-b1f5-0d7a2aea6423" /><br>
<img width="506" height="113" alt="Screenshot 2025-10-01 221029" src="https://github.com/user-attachments/assets/2725f940-1b49-47f2-93d8-393034986bf8" /><br>
<img width="228" height="53" alt="Screenshot 2025-10-01 221037" src="https://github.com/user-attachments/assets/7855ce4c-c312-4788-a410-b4d9e7c360cd" /><br>


Error Scenarios:

<img width="439" height="74" alt="Screenshot 2025-10-01 221250" src="https://github.com/user-attachments/assets/4cff25f9-360b-48e7-8c21-8775f74edca0" /><br>


## Strategy Pattern - Payment Processing System
**PaymentStrategy.java**: Interface defining the payment strategy.

**CreditCardPayment.java**: Concrete strategy for credit card payments with validation and card masking.

**PayPalPayment.java**: Concrete strategy for PayPal payments with email validation.

**PaymentProcessor.java**: Context class that uses the payment strategy.

**PaymentApp.java**: Main application demonstrating different payment strategies with user input.

<img width="292" height="118" alt="Screenshot 2025-10-01 221722" src="https://github.com/user-attachments/assets/997c3e04-48ce-417b-9df5-c6eeab1418da" /><br>
<img width="855" height="124" alt="Screenshot 2025-10-01 221728" src="https://github.com/user-attachments/assets/28861370-ef41-45ba-943c-a926357bfe0c" /><br>
<img width="739" height="134" alt="Screenshot 2025-10-01 221739" src="https://github.com/user-attachments/assets/a9676efb-8ef6-4040-b9d9-9a6f58fc1b4d" /><br>

Error Scenarios:

<img width="483" height="107" alt="Screenshot 2025-10-01 221748" src="https://github.com/user-attachments/assets/9ac1d7db-ee4a-42da-a903-32702286820c" />
<img width="355" height="101" alt="Screenshot 2025-10-01 221752" src="https://github.com/user-attachments/assets/74d2b4a6-64f2-485d-9f1b-8fa95b6229f5" /><br>


## *Creational Patterns*

## Builder Pattern - Report Builder System
**Report.java**: Product class with inner Builder class for step-by-step construction.

**Report.Builder.java**: Static inner builder class with fluent interface.

**ReportBuilderApp.java**: Main application that demonstrates building reports with validation and user input.

<img width="277" height="115" alt="Screenshot 2025-10-01 223242" src="https://github.com/user-attachments/assets/7de95d22-b53e-4c08-bd04-aa2a96e990d9" /><br>
<img width="1180" height="186" alt="Screenshot 2025-10-01 223315" src="https://github.com/user-attachments/assets/b54dad92-f98b-4505-8ad4-b527a5381e6b" /><br>
<img width="1013" height="129" alt="Screenshot 2025-10-01 223323" src="https://github.com/user-attachments/assets/a62b20f1-1d13-4669-8de0-ee39118d7e54" /><br>


Error Scenarios:

<img width="356" height="48" alt="Screenshot 2025-10-01 223327" src="https://github.com/user-attachments/assets/6f0ce4ad-280c-4ddb-94d7-37aa55b1a9da" /><br>



## Factory Pattern - Notification System
**Notification.java**: Interface for notification types.

**EmailNotification.java**: Concrete notification for email with validation.

**SMSNotification.java**: Concrete notification for SMS with character limit validation.

**PushNotification.java**: Concrete notification for push notifications.

**NotificationFactory.java**: Factory class that creates appropriate notification instances.

**NotificationSystem.java**: Main application with comprehensive menu system for single and bulk notifications.

<img width="461" height="162" alt="Screenshot 2025-10-01 224217" src="https://github.com/user-attachments/assets/df12d6ea-d02c-4c4d-bdcd-fd00bae9f75c" /><br>
<img width="909" height="421" alt="Screenshot 2025-10-01 224250" src="https://github.com/user-attachments/assets/f6fc59f7-8fa2-4bfe-83be-ca110cddc79a" /><br>


Error Scenarios:

<img width="351" height="98" alt="Screenshot 2025-10-01 224258" src="https://github.com/user-attachments/assets/e3843c65-3d58-4477-985f-a63f9dbed7d4" />
<img width="420" height="61" alt="Screenshot 2025-10-01 224307" src="https://github.com/user-attachments/assets/9aaaba56-46d8-4f21-9374-b33f41c318e4" /><br>


## *Structural Patterns*

## Adapter Pattern - Legacy Payment Integration
**ModernPayment.java**: Target interface for modern payment system.

**LegacyPaymentSystem.java**: Adaptee class with incompatible interface.

**LegacyPaymentAdapter.java**: Adapter that bridges modern interface with legacy system.

**Adapter.java**: Main application demonstrating payment processing with format adaptation and validation.

<img width="384" height="141" alt="Screenshot 2025-10-01 225327" src="https://github.com/user-attachments/assets/c8653014-a514-48d7-b6ba-f4869679a22d" /><br>
<img width="606" height="177" alt="Screenshot 2025-10-01 225355" src="https://github.com/user-attachments/assets/a26ffc40-c2c3-490e-99a8-fb20fa17aae8" /><br>
<img width="683" height="655" alt="Screenshot 2025-10-01 225403" src="https://github.com/user-attachments/assets/713f90fc-2913-4984-b790-4ebd45c2597d" /><br>



Error Scenarios:

<img width="475" height="156" alt="Screenshot 2025-10-01 225412" src="https://github.com/user-attachments/assets/b917ca45-3229-4cd4-aa26-13eb698f5012" /><br>


## Decorator Pattern - Coffee Shop Order System
**Drink.java**: Component interface for drinks.

**Coffee.java**: Concrete component representing base coffee.

**DrinkDecorator.java**: Abstract decorator class.

**MilkDecorator.java**: Concrete decorator adding milk functionality.

**SugarDecorator.java**: Concrete decorator adding sugar functionality.

**CreamDecorator.java**: Concrete decorator adding cream functionality.

**CoffeeShop.java**: Main application that dynamically builds drinks with user-selected decorators.


<img width="383" height="100" alt="Screenshot 2025-10-01 230014" src="https://github.com/user-attachments/assets/cb3cd784-643a-4ddc-be72-9544d6e156b8" /><br>
<img width="529" height="302" alt="Screenshot 2025-10-01 230022" src="https://github.com/user-attachments/assets/8e79e063-7e86-4acf-887a-58b482751e0a" /><br>



# Exercise 2: Virtual Classroom Manager

## Problem Statement
A console-based application for managing virtual classrooms, student enrollment, and assignment submissions in an educational platform.

## Architecture

### Model Layer
**Classroom.java**: Represents a classroom with students and assignments.

**Student.java**: Student entity with ID and name.

**Assignment.java**: Assignment entity with title, description and submission tracking.

### Service Layer
**ClassroomService.java**: Singleton service handling all classroom operations with business logic.

**ValidationService.java**: Comprehensive validation for all inputs and business rules.

### Utility Layer
**Logger.java**: Custom logging implementation with timestamps and log levels.

### Main Application
**VirtualClassroomManager.java**: Main class with command processing and user interface.

## Features

### Classroom Management
- Create and remove virtual classrooms
- List all available classrooms
- Validation for classroom names and duplicates

### Student Management
- Enroll students in classrooms
- List students by classroom
- Student ID and name validation

### Assignment Management
- Schedule assignments for classrooms
- Student assignment submission
- Track assignment submissions

## Design Patterns Used

### Singleton Pattern
**ClassroomService.java**: Ensures single instance for centralized classroom management.

### Service Layer Pattern
Clean separation between business logic and presentation layer.

### Factory Pattern
Implicit in object creation for Students and Assignments.

## Key Features

- **Comprehensive Validation**: Input validation at all levels
- **Robust Error Handling**: Graceful error handling with user-friendly messages
- **Logging Mechanism**: Timestamped logging with INFO, ERROR, and DEBUG levels
- **Defensive Programming**: Null checks and boundary validation throughout
- **Immutable Objects**: Where appropriate for thread safety

<img width="751" height="346" alt="Screenshot 2025-10-01 215912" src="https://github.com/user-attachments/assets/3a2cb3c2-cb5e-4e6a-b1fb-c4b0e0995b19" /><br>
<img width="597" height="81" alt="Screenshot 2025-10-01 215630" src="https://github.com/user-attachments/assets/7f427a62-954a-4875-8e37-9e16391ea260" /><br>
<img width="667" height="94" alt="Screenshot 2025-10-01 215637" src="https://github.com/user-attachments/assets/8da2aee7-27c9-4627-8914-04360ecf4a65" /><br>
<img width="1138" height="91" alt="Screenshot 2025-10-01 215656" src="https://github.com/user-attachments/assets/3498a49b-9819-4357-b6b6-2cdf1f6a2109" /><br>
<img width="391" height="134" alt="Screenshot 2025-10-01 215807" src="https://github.com/user-attachments/assets/e4ab3fb4-7803-4963-af5c-44d709f578f6" /><br>
<img width="933" height="334" alt="Screenshot 2025-10-01 215728" src="https://github.com/user-attachments/assets/a9eb5928-f9e6-47b8-ab4a-f8fc5d9827f9" /><br>

Error Scnenarios:

<img width="887" height="99" alt="Screenshot 2025-10-01 215649" src="https://github.com/user-attachments/assets/50551683-3f5f-4d09-b195-4df8695b197e" /><br>


# Code Quality Highlights

- **SOLID Principles**: All principles properly applied
- **Clean Architecture**: Well-organized packages and separation of concerns
- **Exception Handling**: Comprehensive try-catch blocks with meaningful messages
- **Performance**: Efficient data structures (HashMaps for O(1) operations)
- **Maintainability**: Easy to extend with new features
- **Documentation**: Clear code structure and organization

---
