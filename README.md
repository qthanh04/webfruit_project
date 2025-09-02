# 🍎 WebFruit - Hệ Thống Bán Trái Cây & Rau Củ Online

## 📋 Mục Lục
- [Tổng Quan](#-tổng-quan)
- [✨ Tính Năng Chính](#-tính-năng-chính)
- [🏗️ Kiến Trúc Hệ Thống](#️-kiến-trúc-hệ-thống)
- [🗄️ Cơ Sở Dữ Liệu](#️-cơ-sở-dữ-liệu)
- [🚀 Hướng Dẫn Cài Đặt](#-hướng-dẫn-cài-đặt)
- [📱 Hướng Dẫn Sử Dụng](#-hướng-dẫn-sử-dụng)
- [🔧 API Endpoints](#-api-endpoints)
- [🛠️ Công Nghệ Sử Dụng](#️-công-nghệ-sử-dụng)
- [📁 Cấu Trúc Project](#-cấu-trúc-project)
- [❓ Troubleshooting](#-troubleshooting)
- [🤝 Đóng Góp](#-đóng-góp)

---

## 🌟 Tổng Quan

**WebFruit** là một ứng dụng web bán trái cây và rau củ trực tuyến với hệ thống giỏ hàng hoàn chỉnh. Ứng dụng được xây dựng bằng **Spring MVC**, **Hibernate** và **MySQL**, cung cấp trải nghiệm mua sắm trực tuyến mượt mà và thân thiện với người dùng.

### 🎯 Mục Tiêu
- Cung cấp nền tảng mua sắm trái cây, rau củ trực tuyến
- Hệ thống giỏ hàng thông minh với tính năng quản lý đơn hàng
- Giao diện người dùng hiện đại và responsive
- Hệ thống xác thực và phân quyền người dùng

---

## ✨ Tính Năng Chính

### 🛒 **Hệ Thống Giỏ Hàng Thông Minh**
- **Thêm sản phẩm**: Click vào icon 🛒 trên mỗi sản phẩm
- **Quản lý số lượng**: Tăng/giảm số lượng với nút +/- 
- **Xóa sản phẩm**: Xóa từng sản phẩm hoặc xóa toàn bộ giỏ hàng
- **Tính toán tự động**: Tự động tính tổng tiền và số lượng sản phẩm
- **Lưu trữ session**: Giỏ hàng được lưu trữ theo từng người dùng

### 💳 **Hệ Thống Thanh Toán**
- **Form thanh toán**: Giao diện nhập thông tin giao hàng
- **Phương thức thanh toán**: Credit Card, PayPal, Tiền mặt khi nhận hàng
- **Xác nhận đơn hàng**: Hiển thị tổng quan trước khi đặt hàng
- **Quản lý đơn hàng**: Theo dõi trạng thái đơn hàng

### 🔐 **Hệ Thống Xác Thực & Phân Quyền**
- **Đăng nhập/Đăng xuất**: Hệ thống xác thực an toàn
- **Quản lý session**: Theo dõi trạng thái đăng nhập
- **Phân quyền truy cập**: Kiểm soát quyền truy cập các trang
- **Bảo mật**: Bảo vệ thông tin người dùng

### 🎨 **Giao Diện Người Dùng**
- **Responsive Design**: Tương thích với mọi thiết bị
- **Bootstrap 4**: Giao diện hiện đại và đẹp mắt
- **Animations**: Hiệu ứng chuyển động mượt mà
- **Navigation**: Menu điều hướng trực quan

---

## 🏗️ Kiến Trúc Hệ Thống

### 📊 **Mô Hình Kiến Trúc**
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Frontend      │    │   Backend       │    │   Database      │
│   (JSP + JS)    │◄──►│   (Spring MVC)  │◄──►│   (MySQL)       │
│                 │    │                 │    │                 │
│ • Bootstrap     │    │ • Controllers   │    │ • User          │
│ • jQuery        │    │ • Services      │    │ • Product       │
│ • JSP           │    │ • DAOs          │    │ • ShoppingCart  │
└─────────────────┘    │ • Entities      │    │ • CartItem      │
                       └─────────────────┘    └─────────────────┘
```

### 🔄 **Luồng Xử Lý**
1. **User Request** → Frontend (JSP)
2. **Controller** → Xử lý logic nghiệp vụ
3. **Service Layer** → Xử lý business logic
4. **DAO Layer** → Truy xuất dữ liệu
5. **Database** → Lưu trữ và truy vấn
6. **Response** → Trả về kết quả cho người dùng

---

## 🗄️ Cơ Sở Dữ Liệu

### 📋 **Cấu Trúc Bảng**

#### **1. Bảng `user`**
```sql
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullName VARCHAR(100),
    email VARCHAR(100),
    role VARCHAR(20) DEFAULT 'user',
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### **2. Bảng `product`**
```sql
CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    salePrice DECIMAL(10,2),
    discount INT DEFAULT 0,
    imageProduct VARCHAR(500),
    category VARCHAR(100),
    stock INT DEFAULT 0,
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### **3. Bảng `shoppingcart`**
```sql
CREATE TABLE shoppingcart (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES user(id)
);
```

#### **4. Bảng `cart_item`**
```sql
CREATE TABLE cart_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    productId INT NOT NULL,
    shoppingCartId INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (productId) REFERENCES product(id),
    FOREIGN KEY (shoppingCartId) REFERENCES shoppingcart(id)
);
```

### 🌱 **Dữ Liệu Mẫu**

#### **Sản Phẩm Mẫu**
| ID | Tên Sản Phẩm | Giá Gốc | Giá Khuyến Mãi | Giảm Giá | Mô Tả |
|----|---------------|----------|-----------------|----------|-------|
| 1 | 🍎 Táo Tươi | $2.99 | $2.49 | 15% | Táo đỏ giòn ngọt, giàu vitamin |
| 2 | 🍌 Chuối Hữu Cơ | $1.99 | $1.79 | 10% | Chuối vàng tự nhiên, không hóa chất |
| 3 | 🍅 Cà Chua Tươi | $3.49 | $2.99 | 20% | Cà chua đỏ mọng, thịt dày |
| 4 | 🥬 Rau Xà Lách | $1.99 | $1.99 | 0% | Rau xanh giòn, tươi mới |
| 5 | 🍊 Cam Ngọt | $4.99 | $3.99 | 25% | Cam mọng nước, vị ngọt tự nhiên |
| 6 | 🥕 Cà Rốt Tươi | $2.49 | $2.49 | 0% | Cà rốt cam đậm, giàu beta-carotene |
| 7 | 🫑 Ớt Chuông Đỏ | $3.99 | $3.49 | 15% | Ớt chuông đỏ tươi, vị ngọt |
| 8 | 🍓 Dâu Tây Tươi | $5.99 | $4.99 | 20% | Dâu tây đỏ mọng, hương thơm |

#### **Tài Khoản Mẫu**
| Username | Password | Role | Tên Đầy Đủ | Email |
|----------|----------|------|-------------|-------|
| `admin` | `admin123` | admin | Administrator | admin@webfruit.com |
| `user1` | `user123` | user | John Doe | john@example.com |
| `customer` | `customer123` | customer | Jane Smith | jane@example.com |

---

## 🚀 Hướng Dẫn Cài Đặt

### 📋 **Yêu Cầu Hệ Thống**
- **Java**: JDK 8 hoặc cao hơn
- **Maven**: 3.6.0 hoặc cao hơn
- **MySQL**: 8.0 hoặc cao hơn
- **Tomcat**: 9.0 hoặc cao hơn
- **IDE**: IntelliJ IDEA, Eclipse, hoặc VS Code

### 🗄️ **Bước 1: Cài Đặt Database**

#### **1.1 Tạo Database**
```sql
-- Kết nối MySQL
mysql -u root -p

-- Tạo database
CREATE DATABASE webfruitproject CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Sử dụng database
USE webfruitproject;
```

#### **1.2 Cập Nhật Authentication (MySQL 8.x)**
```sql
-- Thay đổi authentication method
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';

-- Cập nhật quyền
FLUSH PRIVILEGES;

-- Kiểm tra
SELECT user, host, plugin FROM mysql.user WHERE user = 'root';
```

### ⚙️ **Bước 2: Cấu Hình Ứng Dụng**

#### **2.1 Cập Nhật Database Connection**
File: `src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml`

```xml
<!-- Database Configuration -->
<beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
    <beans:property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <beans:property name="url" value="jdbc:mysql://localhost:3306/webfruitproject?useSSL=false&amp;serverTimezone=UTC&amp;characterEncoding=UTF-8"/>
    <beans:property name="username" value="root"/>
    <beans:property name="password" value="root"/>
    <beans:property name="initialSize" value="5"/>
    <beans:property name="maxActive" value="20"/>
</beans:bean>
```

#### **2.2 Kiểm Tra Hibernate Configuration**
```xml
<beans:bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
    <beans:property name="dataSource" ref="dataSource"/>
    <beans:property name="packagesToScan" value="com.springmvc.webfruit.entity"/>
    <beans:property name="hibernateProperties">
        <beans:props>
            <beans:prop key="hibernate.dialect">org.hibernate.dialect.MySQL57Dialect</beans:prop>
            <beans:prop key="hibernate.show_sql">true</beans:prop>
            <beans:prop key="hibernate.hbm2ddl.auto">update</beans:prop>
            <beans:prop key="hibernate.connection.characterEncoding">UTF-8</beans:prop>
        </beans:props>
    </beans:property>
</beans:bean>
```

### 🔨 **Bước 3: Build và Deploy**

#### **3.1 Build Project**
```bash
# Clean và build
mvn clean package

# Kiểm tra target folder
ls -la target/
# Kết quả: webfruit-1.0.0-BUILD-SNAPSHOT.war
```

#### **3.2 Deploy lên Tomcat**
```bash
# Copy WAR file vào webapps
cp target/webfruit-1.0.0-BUILD-SNAPSHOT.war $TOMCAT_HOME/webapps/

# Hoặc chạy với embedded Tomcat
mvn tomcat7:run
```

#### **3.3 Kiểm Tra Ứng Dụng**
- **URL**: `http://localhost:8080/webfruit/`
- **Database**: Kiểm tra các bảng đã được tạo tự động
- **Logs**: Kiểm tra console để đảm bảo không có lỗi

---

## 📱 Hướng Dẫn Sử Dụng

### 🏠 **1. Trang Chủ (Home)**
- **URL**: `http://localhost:8080/webfruit/`
- **Chức năng**: 
  - Xem danh sách sản phẩm nổi bật
  - Thông tin về cửa hàng
  - Navigation menu chính

### 🔐 **2. Đăng Nhập**
- **Cách 1**: Click nút "Login" trên navigation bar
- **Cách 2**: Truy cập trực tiếp: `http://localhost:8080/webfruit/login`
- **Tài khoản test**:
  ```
  Username: admin
  Password: admin123
  ```

### 🛍️ **3. Mua Sắm**
- **Bước 1**: Sau khi đăng nhập, click "Shop" trên menu
- **Bước 2**: Xem danh sách sản phẩm
- **Bước 3**: Click icon 🛒 để thêm vào giỏ hàng
- **Bước 4**: Chọn số lượng và xác nhận

### 🛒 **4. Quản Lý Giỏ Hàng**
- **Xem giỏ hàng**: Click icon giỏ hàng trên navigation
- **Cập nhật số lượng**: Sử dụng nút +/- 
- **Xóa sản phẩm**: Click nút "Remove"
- **Xóa toàn bộ**: Click "Clear Cart"

### 💳 **5. Thanh Toán**
- **Bước 1**: Từ giỏ hàng, click "Proceed to Checkout"
- **Bước 2**: Điền thông tin giao hàng
- **Bước 3**: Chọn phương thức thanh toán
- **Bước 4**: Xác nhận đơn hàng

---

## 🔧 API Endpoints

### 🛒 **Cart Management**
| Method | Endpoint | Mô Tả | Parameters |
|--------|----------|-------|------------|
| `POST` | `/cart/add` | Thêm sản phẩm vào giỏ hàng | `productId`, `quantity` |
| `POST` | `/cart/update` | Cập nhật số lượng | `itemId`, `quantity` |
| `POST` | `/cart/remove` | Xóa sản phẩm | `itemId` |
| `POST` | `/cart/clear` | Xóa toàn bộ giỏ hàng | - |
| `GET` | `/cart/view` | Xem giỏ hàng | - |

### 💳 **Checkout**
| Method | Endpoint | Mô Tả | Parameters |
|--------|----------|-------|------------|
| `GET` | `/checkout` | Trang thanh toán | - |
| `POST` | `/checkout/place-order` | Đặt hàng | `shippingInfo`, `paymentMethod` |

### 🔐 **Authentication**
| Method | Endpoint | Mô Tả | Parameters |
|--------|----------|-------|------------|
| `GET` | `/login` | Trang đăng nhập | - |
| `POST` | `/login` | Xử lý đăng nhập | `username`, `password` |
| `GET` | `/logout` | Đăng xuất | - |

### 🏠 **Pages**
| Method | Endpoint | Mô Tả | Access |
|--------|----------|-------|--------|
| `GET` | `/` | Trang chủ | Public |
| `GET` | `/shop` | Trang mua sắm | Public |
| `GET` | `/cart/view` | Xem giỏ hàng | Authenticated |
| `GET` | `/checkout` | Thanh toán | Authenticated |

---

## 🛠️ Công Nghệ Sử Dụng

### **Backend Framework**
- **Spring MVC 5.0.2**: Web framework chính
- **Hibernate 5.2.12**: ORM framework
- **Spring ORM**: Tích hợp Spring với Hibernate

### **Database & Connection**
- **MySQL 8.x**: Hệ quản trị cơ sở dữ liệu
- **Apache DBCP**: Connection pooling
- **MySQL Connector/J**: JDBC driver

### **Frontend Technologies**
- **Bootstrap 4**: CSS framework responsive
- **jQuery 3.2.1**: JavaScript library
- **JSP (JavaServer Pages)**: Template engine
- **JSTL**: JSP Standard Tag Library

### **Build & Deployment**
- **Maven 3.6+**: Build automation tool
- **Apache Tomcat 9**: Web server & servlet container
- **Java 8+**: Runtime environment

### **Development Tools**
- **IntelliJ IDEA**: IDE chính (khuyến nghị)
- **Git**: Version control
- **Maven**: Dependency management

---

## 📁 Cấu Trúc Project

```
WebFruit_Project/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   └── 📁 com/springmvc/webfruit/
│   │   │       ├── 📁 controller/          # Controllers
│   │   │       ├── 📁 service/             # Business Logic
│   │   │       ├── 📁 dao/                 # Data Access Objects
│   │   │       └── 📁 entity/              # Hibernate Entities
│   │   ├── 📁 resources/                   # Configuration files
│   │   └── 📁 webapp/
│   │       ├── 📁 WEB-INF/
│   │       │   ├── 📁 views/               # JSP pages
│   │       │   ├── 📁 spring/              # Spring configuration
│   │       │   └── web.xml                 # Web deployment descriptor
│   │       └── 📁 resources/               # Static resources
│   │           ├── 📁 css/                 # Stylesheets
│   │           ├── 📁 js/                  # JavaScript files
│   │           └── 📁 images/              # Image files
│   └── 📁 test/                            # Test files
├── 📁 target/                               # Build output
├── 📄 pom.xml                               # Maven configuration
├── 📄 README.md                             # Project documentation
└── 📄 .gitignore                            # Git ignore rules
```

### **Key Files**
- **`pom.xml`**: Maven dependencies và configuration
- **`servlet-context.xml`**: Spring configuration
- **`web.xml`**: Web application configuration
- **`navigation.jsp`**: Reusable navigation component
- **`navigation.css`**: Navigation styling

---

## ❓ Troubleshooting

### **🔴 Lỗi Database Connection**

#### **Lỗi 1: Access denied for user 'root'@'localhost'**
```bash
# Giải pháp: Cập nhật authentication method
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
FLUSH PRIVILEGES;
```

#### **Lỗi 2: Hibernate dialect không tương thích**
```xml
<!-- Sử dụng MySQL57Dialect cho Hibernate 5.2.x -->
<beans:prop key="hibernate.dialect">org.hibernate.dialect.MySQL57Dialect</beans:prop>
```

### **🔴 Lỗi LazyInitializationException**

#### **Nguyên nhân**: Truy cập lazy-loaded collections ngoài Hibernate session
#### **Giải pháp**: 
1. Sử dụng `JOIN FETCH` trong queries
2. Thay đổi `FetchType.LAZY` thành `FetchType.EAGER`
3. Tính toán totals trong controller

### **🔴 Lỗi 404 - Page Not Found**

#### **Kiểm tra**:
1. URL mapping trong controllers
2. View resolver configuration
3. JSP file locations
4. Tomcat deployment

### **🔴 Lỗi Build Maven**

#### **Giải pháp**:
```bash
# Clean và rebuild
mvn clean package

# Kiểm tra Java version
java -version

# Kiểm tra Maven version
mvn -version
```

---

## 🤝 Đóng Góp

### **Cách Đóng Góp**
1. **Fork** repository này
2. **Tạo branch** mới cho feature: `git checkout -b feature/AmazingFeature`
3. **Commit** thay đổi: `git commit -m 'Add some AmazingFeature'`
4. **Push** lên branch: `git push origin feature/AmazingFeature`
5. **Tạo Pull Request**

### **Báo Cáo Bug**
- Sử dụng **Issues** tab trên GitHub
- Mô tả chi tiết vấn đề gặp phải
- Đính kèm screenshots nếu cần
- Cung cấp steps để reproduce

### **Đề Xuất Tính Năng**
- Tạo **Feature Request** issue
- Mô tả tính năng mong muốn
- Giải thích lý do cần thiết
- Đề xuất cách implement

---

## 📞 Liên Hệ & Hỗ Trợ

### **Thông Tin Liên Lạc**
- **GitHub**: [qthanh04/webfruit_project](https://github.com/qthanh04/webfruit_project)
- **Email**: qthanh04@gmail.com
- **Author**: qthanh04

### **Hỗ Trợ**
- **Documentation**: Xem README này
- **Issues**: Báo cáo bug trên GitHub
- **Wiki**: Hướng dẫn chi tiết (nếu có)

---

## 📄 License

Project này được phát hành dưới **MIT License**. Xem file `LICENSE` để biết thêm chi tiết.

---

## 🙏 Lời Cảm Ơn

Cảm ơn bạn đã quan tâm đến project **WebFruit**! 

Nếu project này hữu ích, hãy:
- ⭐ **Star** repository
- 🔄 **Fork** để phát triển thêm
- 📢 **Share** với cộng đồng
- 💬 **Đóng góp** ý kiến và code

**Happy Coding! 🚀✨**
