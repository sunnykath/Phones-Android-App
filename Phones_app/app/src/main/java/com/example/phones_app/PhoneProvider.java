package com.example.phones_app;

import com.example.phones_app.models.Apple;
import com.example.phones_app.models.Microsoft;
import com.example.phones_app.models.Samsung;

import java.util.ArrayList;

public class PhoneProvider {
    //This class acts like a database
    //Stores attribute information for our smartphone objects
    //Images sourced all from gsmarena.com

    // Apple Phones, denoted by 'a_'
    private static String[] a_Models = {"iPhone SE (2020)", "iPhone 11 Pro", "iPhone 11", "iPhone XR"
            , "iPhone X" , "iPhone 8", "iPhone 8 Plus", "iPhone 7", "iPhone 7 Plus", "iPhone SE"
            , "iPhone 6s", "iPhone 6s Plus", "iPhone 5", "iPhone 5s", "iPhone 5c"};
    private static double[] a_Price = {349.99, 999.00, 749.99, 549.99, 479.99, 260, 499, 194.99, 269.99,
                                        123.99, 119.99, 218.99, 150, 179.99, 144.99};
    private static int[] a_MemoryCapacity = {64, 64, 128, 128, 256, 64, 128, 128, 32, 16, 32, 16, 32,
                                             64, 16};
    private static double[] a_Ratings = {4.0, 4.5, 4.2, 4.1, 4.3, 4.3, 4.4, 4.3, 4.1, 3.7, 4.0, 3.7,
                                        3.5, 4.1, 3.9};

    // URLs to be used by GLIDE
    private static String[][] a_imageUrls =
            {{"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-2020-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-2020-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-2020-3.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-pro-10.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-11-pro-max-5.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-11-pro-max-4.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-11-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-11-3.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-11-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-xr-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-xr-3.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-xr-4.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-x-new-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-x-new-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-x-4.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-8-new-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-8-3.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-8-4.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-8-plus-0.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-8-plus-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-8-plus-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-7-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-7-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-7-3.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-7-plus-01.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-7-plus-03.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-7-plus-4.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-01.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-00.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-1.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-6s-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-6s-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-6s-3.jpg"},
            {"https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-6s-plus.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone6s-plus-1.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/15/apple-iphone-6s-plus/gal/-1024x768w1/gsmarena_001.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5-front.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5-white.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5-white-all-sides.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5s-ofic.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5s-ofic1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5s-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5c-ofic.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5c-ofic1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-5c-colors.jpg"
            }};


    // Microsoft Phones, denoted by 'm_'
    private static String[] m_Models = {"Lumia 550", "Lumia 650", "Lumia 950","Lumia 950 XL", "Lumia 540"
            , "Lumia 430", "Lumia 640 LTE", "Lumia 640 XL", "Lumia 532", "Lumia 435", "Lumia 535"};
    private static double[] m_Price = {199.99, 229.99, 249.99, 299.99, 244.49, 119.99, 239.99,
                                        349.99, 149.99, 139.99, 199.99};
    private static int[] m_MemoryCapacity = {8, 16, 32, 32, 8, 8, 8, 8, 8, 8 , 8};
    private static double[] m_Ratings = {3.6, 4.2, 3.7, 2.6, 4.7, 2.3, 4.1, 3.1, 3.9, 1.9, 2.6};

    private static String[][] m_imageUrls = {
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-550-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-550-2.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/15/microsoft-lumia-550/gal/-1024x768w1/gsmarena_001.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/lumia-650-01.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/16/microsoft-lumia-650/gal/-1024x768w1/gsmarena_001.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/16/microsoft-lumia-650/gal/-1024x768w1/gsmarena_002.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-950-2.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/15/microsoft-lumia-950/gal/-1024x768w1/gsmarena_001.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/15/microsoft-lumia-950/gal/-1024x768w1/gsmarena_003.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-950-xl-2.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/15/microsoft-lumia-950-xl/gal/-1024x768w1/gsmarena_001.jpg",
            "https://fdn.gsmarena.com/imgroot//reviews/15/microsoft-lumia-950-xl/gal/-1024x768w1/gsmarena_002.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-540-ds-0.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-540-ds-01.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-540-ds-1.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-430-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-430-2.jpg",
            "https://www.windowscentral.com/sites/wpcentral.com/files/topic_images/2015/Lumia430_Orange_Front.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/nokia/nokia-lumia-640-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/nokia/nokia-lumia-640-1.jpg",
            "https://fdn.gsmarena.com/vv/reviewsimg/nokia-lumia-640/gal/gsmarena_001.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/nokia/nokia-lumia-640xl-dSIM-4G.jpg",
            "https://fdn2.gsmarena.com/vv/pics/nokia/nokia-lumia-640xl-SSIM-3G.jpg",
            "https://images.priceoye.pk/microsoft-lumia-640-xl-dual-sim-pakistan-priceoye.jpg"},
            {"https://images.priceoye.pk/microsoft-lumia-640-xl-dual-sim-pakistan-priceoye.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-532-22.jpg",
            "https://fdn.gsmarena.com/vv/reviewsimg/microsoft-lumia-532-dual-sim/gal/gsmarena_001.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-435-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-435-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/microsoft/microsoft-lumia-435-1.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/nokia/nokia-lumia-535-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/nokia/nokia-lumia-535-1.jpg",
            "https://www.mytrendyphone.eu/images/Microsoft-Lumia-535-8GB-Factory-Refurbished-Black-15082019-01-p.jpg"}
    };

    // Samsung Phones, denoted by 's_' // Needs work
    private static String[] s_Models = {"Galaxy S20", "Galaxy S20+", "Galaxy S10", "Galaxy S10+",
            "Galaxy S9", "Galaxy S9+", "Galaxy S8", "Galaxy S8+", "Galaxy S7", "Galaxy S7 edge",
            "Galaxy Note10", "Galaxy Note10+", "Galaxy Note9", "Galaxy A20", "Galaxy A10"};
    private static double[] s_Price = {775, 849.49, 579.99, 569.95, 999.99, 556.98, 244.99, 267,
                                        199.99, 209.99, 569.99, 684.99, 388.99, 299.99, 219.99};
    private static int[] s_MemoryCapacity = {128, 128, 512, 512, 256, 128, 64, 64, 32, 32, 256, 512,
                                            128, 32, 32};
    private static double[] s_Ratings = {4.3, 4.4, 4.4, 4.5, 4.7, 4.7, 4.7, 4.7, 4.6, 4.7, 4.7, 4.7,
                                        4.7, 4.6, 4.5};

    private static String[][] s_imageUrls ={
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s20-5g-r1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s20-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s20-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s20-plus-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s20-plus-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s20-plus-3.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s10-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s10-cardinal-red.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s10-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s10-plus-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s10-plus-cardinal-red.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s10-plus-2-ceramic.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-burgundy-red.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-plus-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-plus-ice-blue.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-plus-sunrise-gold.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s8-.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s8-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s8-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s8-plus-.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s8-plus-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s8-plus-2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s7-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s7-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s7-pink.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s7-edge-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s7-edge-2.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s7-edge-pink.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note10-aura-glow.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note10-all-colors.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note10-aura-white.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note10-plus-aura-glow.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note10-plus-all-colors.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note10-plus-aura-black.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note9-1.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note9-3.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-note9-r2.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-a20.jpg",
            "https://cdn.shopify.com/s/files/1/1230/1310/products/Samsung-Galaxy-A20-blue-back_56c58b59-0c2a-460a-b75a-a8b0ba99b107_2048x2048.jpg?v=1579449537",
            "https://www.noelleeming.co.nz/shop/render-image/products/181/181537.530.556.jpg"},
            {"https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-a10-0.jpg",
            "https://fdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-a10-1.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/817qMvqyjBL._AC_SX466_.jpg"}
    };


    public static ArrayList<ArrayList> generateData() {
    //this function generates all our smartphone objects and stores them by their category inside an array list
        ArrayList<ArrayList> phones = new ArrayList<>();
        ArrayList<Microsoft> microsoftPhones = new ArrayList<>();
        ArrayList<Apple> applePhones = new ArrayList<>();
        ArrayList<Samsung> samsungPhones = new ArrayList<>();

        // Apple
        for (int i = 0; i < a_Models.length; i++) {
            Apple aPhone =  new Apple(a_Models[i], a_Price[i], a_Ratings[i], a_MemoryCapacity[i], a_imageUrls[i]);
            applePhones.add(aPhone);
        }

        // Microsoft
        for (int i = 0; i < m_Models.length; i++) {
            Microsoft aPhone =  new Microsoft(m_Models[i], m_Price[i], m_Ratings[i], m_MemoryCapacity[i], m_imageUrls[i]);
            microsoftPhones.add(aPhone);
        }

        // Samsung
        for (int i = 0; i < s_Models.length; i++) {
            Samsung aPhone =  new Samsung(s_Models[i], s_Price[i], s_Ratings[i], s_MemoryCapacity[i], s_imageUrls[i]);
            samsungPhones.add(aPhone);
        }

        //we store the category array lists inside another array list and return it
        phones.add(applePhones);
        phones.add(microsoftPhones);
        phones.add(samsungPhones);
        return phones;
    }


}
