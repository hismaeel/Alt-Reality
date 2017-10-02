#pragma version(1)
#pragma rs java_package_name(com.example.android.camera2basic)
#pragma rs_fp_relaxed


//A renderscript Mapping Kernel that unpacks color of input pixels, does color swap and correction,
// and finally repacks and returns so that the final pixel can be placed into respective position in the output allocation

int i; //used as indicator for button clicks
const static float3 gMonoMult = {0.299f, 0.587f, 0.114f}; //The three multipliers convert RGB to white/black
float saturationValue = 1.3f; //control amount of saturation change we'd like

uchar4 __attribute__((kernel)) convertP(uchar4 pixel, uint32_t x, uint32_t y)
{

    //uchar3 pix;
    //pix.r = pixel.r;
    //pic.g = pixel.g;
    //pixel.b = pixel.b;

    //To swap color elements, there is no need to convert to float. But I do so to perform some
    //color corrections/saturations by doing the multiplication as we see below


    float4 color = rsUnpackColor8888(pixel);
    uchar4 pixelPP = pixel;
    float3 pixelP;


    float r = color.r;
    float g = color.g;
    float b = color.b;
    float a = color.a;



    if (i == 3){
    pixelPP =  rsPackColorTo8888(b,g,r,a);
    }

    if (i == 2){
    pixelPP = rsPackColorTo8888(r,b,g,a);
    }

    if (i == 4){
    pixelPP = rsPackColorTo8888(r*0.5,b,g*1.2,a);
    }

    if (i == 1){
    pixelPP = rsPackColorTo8888(g,r*0.7,b,a);
    }

        float4 pixelPPP = rsUnpackColor8888(pixelPP);
        pixelP = dot(pixelPPP.rgb, gMonoMult);
        pixelP = mix(pixelP, pixelPPP.rgb, saturationValue);

    return rsPackColorTo8888(pixelP) ;
}
