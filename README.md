# WebFruit - Shopping Cart System

## Tổng quan
WebFruit là một ứng dụng web bán trái cây và rau củ với hệ thống giỏ hàng hoàn chỉnh. Ứng dụng được xây dựng bằng Spring MVC, Hibernate và MySQL.

## Tính năng đã thêm

### 1. Shopping Cart System
- **Thêm sản phẩm vào giỏ hàng**: Click vào icon giỏ hàng trên mỗi sản phẩm
- **Xem giỏ hàng**: Truy cập `/cart/view` để xem chi tiết giỏ hàng
- **Cập nhật số lượng**: Tăng/giảm số lượng sản phẩm trong giỏ hàng
- **Xóa sản phẩm**: Xóa từng sản phẩm hoặc xóa toàn bộ giỏ hàng
- **Tính tổng tiền**: Tự động tính tổng giá trị đơn hàng

### 2. Checkout System
- **Form thanh toán**: Nhập thông tin giao hàng và thanh toán
- **Phương thức thanh toán**: Credit Card, PayPal, Cash on Delivery
- **Xác nhận đơn hàng**: Hiển thị tổng quan đơn hàng trước khi đặt

### 3. User Authentication
- **Đăng nhập**: Hệ thống đăng nhập với session management
- **Bảo mật**: Kiểm tra quyền truy cập cho các trang giỏ hàng

## Cấu trúc Database

### Bảng mới được tạo:
1. **cart_item**: Lưu trữ chi tiết giỏ hàng
   - id: Khóa chính
   - productId: ID sản phẩm
   - shoppingCartId: ID giỏ hàng
   - quantity: Số lượng
   - price: Giá sản phẩm

### Bảng được cập nhật:
1. **shoppingcart**: Thêm mối quan hệ với cart_item
2. **product**: Loại bỏ mối quan hệ trực tiếp với shoppingcart

## Sản phẩm mẫu đã có sẵn

Đã thêm 8 sản phẩm mẫu vào database để test:

| ID | Tên sản phẩm | Giá gốc | Giá khuyến mãi | Giảm giá |
|----|--------------|---------|----------------|----------|
| 1 | Fresh Apples | $2.99 | $2.49 | 15% |
| 2 | Organic Bananas | $1.99 | $1.79 | 10% |
| 3 | Fresh Tomatoes | $3.49 | $2.99 | 20% |
| 4 | Green Lettuce | $1.99 | $1.99 | 0% |
| 5 | Sweet Oranges | $4.99 | $3.99 | 25% |
| 6 | Fresh Carrots | $2.49 | $2.49 | 0% |
| 7 | Red Bell Peppers | $3.99 | $3.49 | 15% |
| 8 | Fresh Strawberries | $5.99 | $4.99 | 20% |

## Cài đặt và Chạy

### 1. Cấu hình Database
```sql
-- Tạo database
CREATE DATABASE webfruitproject;

-- Cập nhật authentication method cho MySQL 8.x
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
FLUSH PRIVILEGES;
```

### 2. Cấu hình Application
File: `src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml`
```xml
<beans:property name="url" value="jdbc:mysql://localhost:3306/webfruitproject?useSSL=false&amp;serverTimezone=UTC"/>
<beans:property name="username" value="root" />
<beans:property name="password" value="root"/>
```

### 3. Build và Deploy
```bash
# Clean và build project
mvn clean package

# Deploy WAR file vào Tomcat
# Hoặc chạy với embedded Tomcat
mvn spring-boot:run
```

## Luồng sử dụng

### 1. Trang chủ (Home)
- Truy cập: `http://localhost:8080/webfruit/`
- Xem danh sách sản phẩm và thông tin cửa hàng

### 2. Đăng nhập
- Click vào nút "Login" trên navigation bar
- Hoặc truy cập trực tiếp: `http://localhost:8080/webfruit/login`
- Sử dụng một trong các tài khoản sau:

| Username | Password | Role | Tên |
|----------|----------|------|-----|
| admin | admin123 | admin | Administrator |
| user1 | user123 | user | John Doe |
| customer | customer123 | customer | Jane Smith |

### 3. Mua sắm
- Sau khi đăng nhập, bạn sẽ được chuyển về trang chủ
- Click vào nút "Shop" trên navigation bar
- Hoặc truy cập: `http://localhost:8080/webfruit/shop`
- Click vào icon giỏ hàng (🛒) trên mỗi sản phẩm để thêm vào giỏ hàng

### 4. Xem giỏ hàng
- Click vào icon giỏ hàng trên navigation bar
- Hoặc truy cập: `http://localhost:8080/webfruit/cart/view`
- Cập nhật số lượng hoặc xóa sản phẩm

### 5. Thanh toán
- Click "Proceed to Checkout" từ giỏ hàng
- Điền thông tin giao hàng và thanh toán

## API Endpoints

### Cart Management
- `POST /cart/add` - Thêm sản phẩm vào giỏ hàng
- `POST /cart/update` - Cập nhật số lượng
- `POST /cart/remove` - Xóa sản phẩm khỏi giỏ hàng
- `POST /cart/clear` - Xóa toàn bộ giỏ hàng
- `GET /cart/view` - Xem giỏ hàng

### Checkout
- `GET /checkout` - Trang thanh toán
- `POST /checkout/place-order` - Đặt hàng

### Authentication
- `GET /login` - Trang đăng nhập
- `POST /login` - Xử lý đăng nhập
- `GET /logout` - Đăng xuất

## Công nghệ sử dụng
- **Backend**: Spring MVC 5.0.2, Hibernate 5.2.12
- **Database**: MySQL 8.x
- **Frontend**: Bootstrap, jQuery, JSP
- **Build Tool**: Maven

## Lưu ý
- Đảm bảo MySQL đang chạy và có thể kết nối
- Kiểm tra cấu hình database trong `servlet-context.xml`
- Hibernate sẽ tự động tạo các bảng khi khởi động ứng dụng
- Session management được sử dụng để theo dõi người dùng đăng nhập
