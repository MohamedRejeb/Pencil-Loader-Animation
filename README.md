![slide](https://user-images.githubusercontent.com/41842296/211169423-8e37cb82-e4cf-454e-b4c3-ec358cd08115.png)

# Pencil Loader Animation

Pencil Loader Animation with jetpack compose, The pencil is drawn with canvas 🖌 , I used a circular progress indicator with some linked keyframes for the animation 😄


## Animation Preview


https://user-images.githubusercontent.com/41842296/211169448-b76d06a2-f83e-4133-a536-1db93f6cc84d.mp4

## Gradle

If you are using Groovy:

Add the dependency below to your module's `build.gradle` file:
```groovy
dependencies {
    implementation "io.github.m0coding:pencilloader:1.0.0"
}
```


If you are using Kotlin:
Add the dependency below to your module's `build.gradle.kts` file:
```kotlin
dependencies {
    implementation("io.github.m0coding:pencilloader:1.0.0")
}
```

## How to Use

You can simply call the **PencilLoader** composable function with fixed size and stroke size:
```kotlin
PencilLoader(
    strokeWidth = 14.dp,
    modifier = Modifier
        .size(200.dp)
)
```

## Acknowledgements

 - [Graphics in compose](https://developer.android.com/jetpack/compose/graphics/draw/overview)
 - [Animation in compose](https://developer.android.com/jetpack/compose/animation)


## Authors

- [@M0Coding](https://www.github.com/M0Coding)


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mohamed-benrejeb/)
