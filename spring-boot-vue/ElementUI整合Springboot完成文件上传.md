# 前端
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
<div id="app">
    <el-upload
            action="https://jsonplaceholder.typicode.com/posts/">
        <el-button size="small" type="primary">点击上传</el-button>
    </el-upload>
</div>
</body>
<!-- import Vue before Element -->
<script src="./js/vue.js"></script>
<!-- import JavaScript -->
<script src="./js/index.js"></script>
<script>
    new Vue({
        el: '#app',
    })
</script>
</html>
```
# 后端
```java
@SpringBootApplication
@RestController
public class VueApp {
    public static void main(String[] args) {

        SpringApplication.run(VueApp.class, args);
    }

    @PostMapping("/up")
    public String upload(MultipartFile file) throws IOException {
        String filePath = "d:/" + file.getOriginalFilename();
        File newFile = new File(filePath);
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 文件存储
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getAbsolutePath();
    }
}
```
