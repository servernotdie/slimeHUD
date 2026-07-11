# SlimeHUD

Đã thêm tính năng hiển thị WAILA (What Am I Looking At) cho các khối Slimefun.  
Bạn có thể trực tiếp nhìn thấy tên của khối mà bạn đang nhìn vào, không cần mở menu hay phá khối.  

Có thể thiết lập trong `config.yml` để hiển thị bằng BossBar hoặc ActionBar.  
Thông tin bổ sung về mạng năng lượng/vận chuyển hàng hóa cũng có thể bật hoặc tắt.

Người chơi có thể sử dụng lệnh `/slimehud toggle` để bật/tắt WAILA.

## Tải xuống

<p align="center">
  <a href="https://builds.guizhanss.net/SlimefunGuguProject/SlimeHUD/master">
    <img src="https://builds.guizhanss.net/f/SlimefunGuguProject/SlimeHUD/master/badge.svg" alt="Build status"/>
  </a>
</p>

## Biên dịch
```
mvn clean package
```

## Xem trước

### Phiên bản BossBar

<https://user-images.githubusercontent.com/101147426/180625208-4713a843-e856-475e-ba83-95b5a61786f8.mp4>

### Phiên bản ActionBar

https://user-images.githubusercontent.com/101147426/180625211-cbcfd01d-d418-4e6c-a8ab-55d938d7840e.mp4

## PlaceholderAPI

- `%slimehud_toggle%` trả về trạng thái người chơi đã bật SlimeHUD hay chưa. `true` hoặc `false`.
- `%slimehud_hud%` trả về toàn bộ nội dung hiển thị của HUD, bao gồm tên khối và thông tin bổ sung
- `%slimehud_hud_block%` chỉ chứa tên khối
- `%slimehud_hud_block_info%` chỉ chứa thông tin bổ sung

## Giới hạn

- Minecraft chỉ có 7 màu cho BossBar, trong khi màu chữ trong chat có tới 16 màu.

## Yêu cầu

- Spigot hoặc bản dẫn xuất
- Slimefun

## Credits

*InfinityLib* by Mooy1
*Lombok* by Project Lombok
## Này bản fork từ upstream của nhóm dev người TQ xong dịch :D
Credit: 
---
[Craft233MC](https://github.com/Craft233MC/SlimeHUD)