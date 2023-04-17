فایل سوالات همراه با راه حل آنها در همین پوشه قرار داده شده اند.( به جز راه حل سوال دوم)
دقت کنید که کد سوال اول برای سادگی بیش تر چندان بهینه نوشته نشده است. که میتوانید خودتان بهینه ترش کنید!

راه حل سوال اول، کامل کامل نیست و برای ورودی گرفتن، به  صورت دستی به توابع ورودی داده ام.(حس نوشتن کد ورودی گیر نبود:/)

پیشنهاد میکنم قبل از دیدن راه حل، سعی کنید سوال را حل کنید تا متوجه شوید که به چه کلاس ها یا ساختارهایی برای حل سوال نیاز داریم
قبل از خواندن راه حل سوالات، باید با bitwise operators و شیفت دادن باینری آشنایی اولیه ای داشته باشید که در همین ریپوزیتوری توضیح داده شده اند. همچنین برای سوال دوم 
نیاز است که با مبحث جنریک ها آشنایی داشته باشید که باز هم در همین ریپوزیتوری قرار داده شده است.

در راه حل سوال اول، از استریم ها نیز استفاده شده است که بهترست آشنایی اولیه ای با آنها داشته باشید.

# توضیح راه حل سوال اول
درین سوال از ما خواسته شده که چندجمله ای ها را پیاده سازی کنیم. برای این کار، من سه کلاس تعریف کرده ام. کلاس Nom و کلاس Poly و کلاس Point

کلاس Poly درواقع نمایش دهنده چندجمله ای است. کلاس Nom نمایش دهنده یک تک جمله ای است . نهایتا کلاس Point برای تعریف نقاط n بعدی تعریف شده است.

## Point class:
 این کلاس باید تنها چند عدد صفر و یک در خود ذخیره کند و می تواند همان ArrayList<Integer> تعریف شود. پس مستقیما ازین کلاس ارث بری می کنیم.
 
## Nom class:
این کلاس نمایش دهنده ی یک تک جمله ای است. طبق سوال یک تک جمله با یک ضریب و چند توان تعریف می شود که این فیلدها را در کلاس تعریف کرده ایم. همچنین طبق سوال نیاز است که 
چند تابع برای این کاس تعریف کنیم. از جمله تابع getDegree و همجنین تابع getTotalDegree
### getDegree(int i):
این تابع، توان متغیر i ام را در این تک جمله ای بر می گرداند.
### getTotalDegree():
این تابع نیز برای محاسبه جمع درجه های متغیرهای این تک جمله ای تعریف شده است.
### calc(Point p):
این تابع هم برای محاسبه مقدار تک جمله ای در نقطه داده شده نوشته شده است.

## Poly class:
این کلاس که نمایش دهنده یک چندجمله ای است، شامل چندین تابع می شود که ظبق نیاز سوال نوشته شده اند:

### calculate(Point p):
هدف این تابع، محاسبه مقدار چند جمله ای در نقطه p است.
### get_sum():
هدف این تابع محاسبه جمع چند حمله ای ظبق تعریف سوال است. در واقع باید تمام ورودی های ممکن به چندجمله ای را بدهیم و مقادیر حاصل را با هم جمه کنیم.
### get_degree(int i):
این تابع نیز طبق تعریف سوال، درجه متغیر i را بر می گرداند که برابر بزرگترین درجه چند جمله ای در تک جمله ای هاست.
### get_degree():
این تابع نیز ظبق تعریف صورت سوال، درجه کل چندجمله ای را برمی گرداند.
 
# راه حل سوال سوم قسمت سوم:
```java
1. public class Mean{
2.    public static void main(String[] args){
3.        int N = args[0];
4.        int[] a= new int[N];
5.        for(int i = 0 ; i < N ; i++)
6.            a[i] = StdIn.readInt();
7.        int sum = a[0];
8.        for(int i = 1 ; i<=N ; i++)
9.            sum = sum + a[i];
10.        StdOut.println("Mean:"+sum/N);
11.    }
12. }
```
مشکلات سوال:
 1. درخط 3 args[0] که در ورودی تابع تعریف شده است، از جنس استرینگ است اما مساوی N که اینت است قرار داده شده است.(compile time error)
 2. درخطوط 6 و 10 از اشیاء StdOut و StdIn استقاده شده است اما هیچ پکیجی ایمپورت نشده است و میدانیم که خود جاوا چنین اشیایی را شامل نمی شود.(compile time error)
 3. در خط 10، اگر N صفر شود، برنامه کرش می کند و استثنا تولید می شود.(runtime error)
 4. در خط 8، در تعریف حلفه فور، N باید از 0 تا N-1 تغییر کند اما درین حلقه از 1 تاN تغییر می کند.(runtime error)