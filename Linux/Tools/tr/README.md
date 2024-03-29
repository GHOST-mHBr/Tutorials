<div dir="rtl">

# ابزار tr 
ازین ابزار برای حذف یا تبدیل کارکترهای یک متن یا فایل استفاده می شود.

tr -> delete or translate characters

شکل کلی دستور به صورت زیر است:

tr [OPTIONS]... STRING1 [STRING2]

که STRING1 و STRING2 بصورت آرایه ای از کارکترها هستند.

## حذف یک یا چند حرف(کارکتر)
برای حذف کردن یک لیست از کارکترها از یک متن دلخواه باید از فلگ delete استفاده کنیم. پس دستور به شکل زیر خواهد بود:

delete flag: -d or --delete
```shell
tr -d 'LIST'
```
به اینصورت هر کارکتری که در LIST قرار داشته باشد از متن ورودی به دستور حذف خواهد شد.
### مثال 1
مثلا اگر بخواهیم از یک متن کارکترهای عددی را حذف کنیم می توانیم از دستور به شکل زیر استفاده کنیم:
```shell
> echo "Input12 45678Strin45g127" | tr -d '0123456789'
Input String
```

یا میتوانیم به شکل زیر از دستور استفاده کنیم:
```shell
> echo "i12n48put s45t9r8ing" | tr -d [:digit:]
input string
```
این مورد را در بخش مقادیر خاص لیست های ورودی بیش تر توضیح خواهیم داد
## تبدیل حروف
برای تبدیل یک یا چند کارکتر به یک یا چند کارکتر دیگر در حالت کلی از دستور بدون هیچ فلگی استفاده می کنیم.
شکل کلی دستور مانند زیر نوشته می شود:
```shell
tr 'LIST1' 'LIST2'
```
این شکل از دستور منجر می شود که کارکترهای موجود در LIST1 به کارکترهای موجود در LIST2 مپ بشوند.
یعنی اولین کارکتر LIST1 تبدیل به اولین کارکتر LIST2 می شود،
دومین کارکتر LIST1 تبدیل به دومین کارکتر LIST2 می شود و الی آخر.
پس باید طول LIST1 با طول LIST2 برابر باشد. اگر طول LIST2 بزرگتر از طول LIST1 باشد، کارکترهای اضافی از LIST2 حذف می شوند.
اما اگر طول LIST1 بزرگتر از طول LIST2 باشد، بطور پیش فرض کارکتر آخر LIST2 انقدر تکرار می شود که طول دو لیست برابر شوند.
حال اگر از فلگ t استفاده کنیم بجای بزرگ شدن LIST2 کارکترهای LIST1 از آخر آنقدر حذف می شوند که طول دو لیست یکسان شود.

همچنین برای یکسان کردن طول دو لیست می توان از کارکتر ستاره(*) استفاده کرد که در بخش مقادیر خاص لیست های ورودی توضیح داده شده است.
### مثال 2
به عنوان مثال فرض کنید می خواهیم یک متن که با دونقطه کلماتش از هم جدا شده اند را تبدیل به متنی کنیم که کلماتش با اسپیس از هم جدا شده اند. با استفاده ازین ابزار براحتی مانند زیر می توانیم این عمل را انجام دهیم:
```shell
> echo "colon:separated:text" | tr ':' ' '
colon separated text
```

حال فرض کنید در مثال قبل به جای دونقطه(کالن)، گاهی دونقطه و گاهی سمیکالن داشته باشیم و باز بخواهیم متن را تبدیل به متنی کنیم که کلماتش با اسپیس جدا شده اند. اینجا از یک لیست از کارکترها به جای تک کارکتر استفاده می کنیم. به شکل زیر میتوانیم این کار را انجام دهیم:
```shell
> echo "colon:and:semicolon;separated;text" | tr ':;' ' '
colon and semicolon separated text
```
## مقادیر خاص لیست های ورودی
همانطور که در مثال یک دیدید، لیست کارکترهای ورودی حتما نباید لیستی از کارکترها باشد. بلکه میتواند مقادیری مثل [:digit:] داشته باشد. درین قسمت به بررسی این موضوع می پردازیم.
به طور کلی، یک لیست میتواند علاوه بر لیست معمولی یکی از موارد زیر باشد:
* \\\\ (backslash)
* \n (newline)
* \b (backspace)
* \f (form feed)
* \r (return)
* \t horizental tab
* \v vertical tab
---
* CHAR1-CHAR2

لیستی از CHAR1 تا CHAR2 در ترتیب صعودی
* [CHAR*]

فقط برای کارکترهای LIST2 قابل استفاده شدن است و به این معنی است که طول این لیست را با کپی کردن CHAR برابر طول LIST1 بکن.
* [CHAR*REPEAT]

در هرکدام از لیست ها می تواند استفاده شود و به این معنی است که CHAR را به تعداد REPEAT تکرار کن.
* [:digit:] (همه اعداد)
* [:alnum:] (همه حروف و ارقام)
* [:alpha:] (همه حروف)
* [:blank:] (همه کارکترهای فاصله ی افقی از قبیل اسپیس و تب)
* [:space:] (همه کارکترهای فاصله ی افقی یا عمودی)
* [:cntrl:] (همه کارکترهای کنترلی)
* [:graph:] (همه کارکترهای قابل چاپ به جز اسپیس)
* [:print:] (همه کارکترهای قابل چاپ بعلاوه اسپیس)
* [:lower:] (همه حروف کوچک)
* [:upper:] (همه حروف بزرگ)
* [:punct:] (همه علائم نگارشی)
* [:xdigit:] (همه کارکترهای هگزادسیمال)
* [=CHAR=] 

(همه کارکترهایی که معادل CHAR باشند مثلا کارکتر é در اسپانیایی معادل e در انگلیسی است)


### مثال ها
* #### تبدیل متن با حروف کوچک به حروف بزرگ با دو روش مختلف

<br>

روش اول:
```shell
> echo "input string in lower case" | tr "a-z" "A-Z"
INPUT STRING IN LOWER CASE
```
روش دوم:
```shell
> echo "text for example 2" | tr [:lower:] [:upper:]
TEXT FOR EXAMPLE 2
```

* #### حذف تب ها و اسپیس های اضافه و مرتب نمودن فایل
می خواهیم یک فایل که کلماتش با یک یا چند تب و اسپیس از هم جدا شده اند را مرتب نموده و کلماتش را تنها با یک اسپیس از هم جدا نماییم. اینجاست که فلگ squeeze استفاده می شود.

squeeze(-s): باعث می شود که کارکترهای تکراری متن ورودی حذف شده و تنها یکی از آنها باقی بماند. دقت کنید که این دستور بعد از تبدیل حروف اجرا می شود.

```shell
> cat badFile
Hello from	America! 
I'am going 		to see you!.

> tr -s [:blank:] ' ' < badFile > goodFile

> cat goodFile
Hello from America! 
I'am going to see you!.
```

#### مثال استفاده از کارکتر ستاره در LIST2
در بخش تبدیل حروف گفتیم که بطور پیش فرض اگر طول LIST2 کم باشد، کارکتر آخر آن کپی می شود. مثال های زیر به درک این مطلب کمک خواهد کرد.
```shell
> echo "Hello!, i'm testing tr!" | tr '!,' '.'
Hello.. i'm tesing tr.
```

```shell
> echo "another text just for you!" | tr 'atjfy' '12'
1no2her 2ex2 2us2 2or 2ou!
```
همانطور که می بینید کارکتر a با 1 جایگزین شد اما تمامی کارکترهای دیگر یعنی t, j, f و y با 2 جایگزین شده اند.
این مطلب نشان دهنده این است که لیست2 به `12222`  تبدیل شده است که گفتیم این، رفتار پیش فرض دستور است.


حال اگر بخواهیم کارکتر یک را انقدر کپی کنیم که طول دو لیست برابر شوند یعنی لیست2 به `11112` تبدیل شود می توانیم از علامت ستاره استفاده کنیم:
```shell
> echo "another text just for you!" | tr 'atjfy' '[1*]2'
1no1her 1ex1 1us1 1or 2ou!
```

حالا اگر مثلا خواسته باشیم که LIST2 به شکل `12211` در بیاید باید چه کنیم؟ اینجا هم میتوانیم از ستاره استفاده کنیم. مانند زیر:

```shell
> echo "another text just for you!" | tr 'atjfy' '1[2*2]1'
1no2her 2ex2 2us2 1or 1ou!
```
در این مثال لیست2 به شکل `1221` تبدیل می شود. سپس چون طول یکسانی با لیست1 ندارد کارکتر آخرش کپی شده و به لیست `12211` تبدیل می شود که همان چیزی است که می خواستیم.

### -c flag
درآخر می توانیم با این فلگ به جای انتخاب لیست1 هر جیزی به جز لیست1 را انتخاب کنیم. مثلا اگر دستور زیر را داشته باشیم:
```shell
> echo "final text" | tr f m 
minal text
```
و از فلگ c استفاده کنیم انتظار داریم به جای f هرچیزی به جز f انتخاب شود:
```shell
> echo "final text" | tr -c f m
fmmmmmmmmmm
```
در نهایت فلگ های version و help نیز قرار دارند و می توانند استفاده شوند.
```shell
> tr --version
tr (GNU coreutils) 9.1
Copyright (C) 2022 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <https://gnu.org/licenses/gpl.html>.
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.

Written by Jim Meyering.
```

</div>