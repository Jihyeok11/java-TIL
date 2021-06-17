vsCode에서확장 프로그램 설치

- spring boot extension pack

- java extension pack 



`File`- `Preferences` - `jdk 입력해서 검색`- `Java: Home , Specifies the folder path to ...` 아래에 `Edit in settings.json`을 클릭해서 설치되어 있는 jdk 경로 설정

```json
{
    "workbench.colorTheme": "Solarized Dark",
    "terminal.integrated.tabs.enabled": true,
    "terminal.integrated.defaultProfile.windows": "Git Bash",
    "editor.suggestSelection": "first",
    "vsintellicode.modify.editor.suggestSelection": "automaticallyOverrodeDefaultValue",
    "files.exclude": {
        "**/.classpath": true,
        "**/.project": true,
        "**/.settings": true,
        "**/.factorypath": true
    },
    "java.home": "C:\\Program Files\\Java\\jdk-11.0.11"
}
```



터미널 창에서 ls 검색해서 mvnw 있으면

```bash
./mvnw spring-boot:run
```

실행해서 spring boot 실행하면 된다.



---

오라클 연동

- VSCode에서 Oracle Developer Tools for VS Code 확장 프로그램 설치
- https://www.oracle.com/database/technologies/appdev/dotnet/install-dotnetcore-windows.html 
  - Install .NET Core Runtime for Windows x64 누르면 dot.net설치가 된다.