# Navigation Component

## 📁 Files

### 1. `navigation.css`
- **Location**: `src/main/webapp/resources/css/navigation.css`
- **Purpose**: Chứa tất cả CSS styling cho navigation và header
- **Features**:
  - Top bar styling với gradient background
  - Navigation bar với hover effects
  - Dropdown menu styling
  - Cart badge với pulse animation
  - Responsive design cho mobile
  - Dark mode support
  - Accessibility improvements

### 2. `navigation.jsp`
- **Location**: `src/main/webapp/WEB-INF/views/fragments/navigation.jsp`
- **Purpose**: JSP fragment chứa HTML structure cho navigation
- **Features**:
  - Top bar với contact info
  - Navigation menu với dropdown
  - Cart badge hiển thị số lượng items
  - Login button
  - Responsive mobile menu

## 🚀 Cách sử dụng

### Bước 1: Include CSS
Thêm vào `<head>` của JSP page:
```html
<link rel="stylesheet" href="resources/css/navigation.css">
```

### Bước 2: Include Navigation Fragment
Thêm vào `<body>` của JSP page:
```html
<jsp:include page="fragments/navigation.jsp" />
```

### Bước 3: Truyền cart count (nếu cần)
Trong Controller, thêm vào Model:
```java
model.addAttribute("totalItems", cartItemCount);
```

## 📱 Responsive Features

- **Desktop**: Full navigation với dropdown menus
- **Tablet**: Collapsed menu với hamburger button
- **Mobile**: Stacked menu items với touch-friendly buttons

## 🎨 Styling Features

- **Gradient backgrounds**: Xanh lá chủ đạo
- **Hover effects**: Transform và color changes
- **Animations**: Pulse cho cart badge, float cho elements
- **Shadows**: Box shadows cho depth
- **Icons**: FontAwesome icons cho tất cả menu items

## 🔧 Customization

### Thay đổi colors:
```css
:root {
    --primary-color: #28a745;
    --secondary-color: #20c997;
    --accent-color: #dc3545;
}
```

### Thay đổi animations:
```css
.cart-badge {
    animation: pulse 2s infinite; /* Thay đổi duration */
}
```

## 📋 Requirements

- Bootstrap 4.x
- FontAwesome icons
- jQuery (cho dropdown functionality)

## 🐛 Troubleshooting

### Navigation không hiển thị:
1. Kiểm tra đường dẫn CSS file
2. Kiểm tra JSP include path
3. Kiểm tra Bootstrap CSS đã load

### Cart badge không update:
1. Kiểm tra `totalItems` trong Model
2. Kiểm tra JavaScript cho AJAX updates
3. Kiểm tra CSS cho cart-badge class

### Mobile menu không hoạt động:
1. Kiểm tra Bootstrap JS đã load
2. Kiểm tra jQuery đã load
3. Kiểm tra data-target attribute
