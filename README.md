# JPushModule
jpush wrap

## 集成

1、引入包

``` gradle
implementation 'com.github.niulinguo:JPushModule:v1.0'
```

2、配置 APP_KEY

``` gradle
defaultConfig {

    ...

    manifestPlaceholders = [
        JPUSH_PKGNAME: applicationId,
        JPUSH_APPKEY : "${properties.getProperty('JPUSH_APPKEY')}",
        JPUSH_CHANNEL: "${properties.getProperty('JPUSH_CHANNEL')}",
    ]
}
```

3、混淆

```
-dontoptimize
-dontpreverify

-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-keep class * extends cn.jpush.android.helpers.JPushMessageReceiver { *; }

-dontwarn cn.jiguang.**
-keep class cn.jiguang.** { *; }
#==================gson && protobuf==========================
-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-keep class com.google.protobuf.** {*;}
```

4、初始化

``` java
JPushManager.init(this);
JPushManager.addListener(this);
```