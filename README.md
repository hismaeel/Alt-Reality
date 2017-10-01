-Copyright 2014 The Android Open Source Project-

Why are trees and grass green? Based on Google's Camera2Basic example, this app uses power of renderscript to swap colors (RGB) right inside preveiw, maintaing smooth framerates (above 25fps). Result? Observe nature in light-blue,purple, blue, or red!
Using a java only solution required getting images from ImageReader, lopping over pixels, doing the yuv to rgb math, swapping colors, and displaying the resulting pixels on a bitmap, which is then passed back to stream. This proved to be very slow (about 2 frames a second!) Renderscript though has been amazing, even color corrections have been possible (multiplying final colors by color-matrix, convolution (sharpening), and increasing saturation). To sum up, this is what's happening: 





![Alt text](/screenshots/6.png?raw=true "Optional Title")
![Alt text](/screenshots/7.png?raw=true "Optional Title")
![Alt text](/screenshots/8.png?raw=true "Optional Title")
![Alt text](/screenshots/9.png?raw=true "Optional Title")
![Alt text](/screenshots/12.png?raw=true "Optional Title")
![Alt text](/screenshots/11.png?raw=true "Optional Title")
















-Author ownership; This project is protected from code reuse. The author does not allow use of this code without prior approval-
