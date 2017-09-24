#pragma version(1)
#pragma rs java_package_name(com.example.android.camera2basic)
#pragma rs_fp_relaxed


int i;

uchar4 __attribute__((kernel)) convertP(uchar4 pixel, uint32_t x, uint32_t y)
{


    float4 color = rsUnpackColor8888(pixel);
    uchar4 pixelPP;

    float r = color.r;
    float g = color.g;
    float b = color.b;
    float a = color.a;


    //float3 color;
    //float color.r = pixel.r;
    //float color.g = pixel.g;
    //float color.b = pixel.b;

    if (i == 3){
    pixelPP =  rsPackColorTo8888(b,g,r*1.3,a);
    }

    if (i == 2){
    pixelPP = rsPackColorTo8888(r,b,g,a);
    }

    if (i == 4){
    pixelPP = rsPackColorTo8888(r*0.4,b,g,a);
    }

    if (i == 1){
    pixelPP = rsPackColorTo8888(g,r*0.4,b,a);
    }

    if (i == 0){
    pixelPP = pixel;
    }

    return pixelPP;
}
