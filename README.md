
Why are trees and grass green? Based on Google's Camera2Basic example, this app uses power of renderscript to swap colors (RGB) right inside preveiw, maintaing smooth framerates (above 25fps). Result? Observe nature in light-blue,purple, blue, or red!
Using a java only solution required getting images from ImageReader, lopping over pixels, doing the yuv to rgb math, swapping colors, and displaying the resulting pixels on a bitmap, which is then passed back to stream. This proved to be very slow (about 2 frames a second!) Renderscript though has been amazing, even color corrections have been possible (multiplying final colors by color-matrix, convolution (sharpening), and increasing saturation).
<br />

1: An input Allocation receives buffers from stream <br />
2: after allocation is populated, the necessary yuv to rgb conversion is done by a ScriptIntrinsicyuvTorgb (ScriptIntrinsics are essentially pre-built mapping kernels) <br />
3: then the custom kernel "convert" is called. This does the chunck of work. It unpacks the rgb colors to float4. After checking for clicks, it swaps the color elements respectively.  <br />
4: the kernel also saturates the final pixels by mixing their respective greyscales with their colors. THe amount of mixing is set by the constant "saturationLevel" (greater than 1.0f saturates the final pixels"<br />
5 After this another intrinsic script is called, ScriptIntrinsicConvolve3x3. This sharpes the images by multiplying a 3x3 chuk of pixels with the convolution matrix. <br />
6 Finally, the final receiveing allocation sends it's surface (on which the ixels are 'drawn') back to the preview stream 
<br />
![Alt text](/screenshots/6.png?raw=true "Optional Title")
![Alt text](/screenshots/7.png?raw=true "Optional Title")
![Alt text](/screenshots/8.png?raw=true "Optional Title")
![Alt text](/screenshots/12.png?raw=true "Optional Title")
![Alt text](/screenshots/11.png?raw=true "Optional Title")
<br />
<br />
Red-Green swap could use some better color correction to red. Or I should upgrade my cam :-)
<br />
<br />
![Alt text](/screenshots/14.png?raw=true "Optional Title")
![Alt text](/screenshots/13.png?raw=true "Optional Title")



-------------------------------------------------UPDATEs OCTOBER--------------------------------------------------------------
RenderScript provides a built in mapping kernel for color multiplications. Using ScriptIntrinsicColorMatrix, we can make a 4x4 matrix and multiply color vectors with it. Putting Linear Algebra to good use, we can easily swap color vectors and do color correction. For instance, a 4x4 Identity matrix will keep a color vector unchanged. But say the matrix {{0,1,0,0} {1,0,0,0} {0,0,1,0} {0,0,0,1}} will swap R and G values! 
Hence don't need to make calls to the custom kernel convert(). Frame Rates should be even better now




-Author ownership; This project is protected from code reuse. The author does not allow use of this code without prior approval-
