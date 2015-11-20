Volley
=====


Volley is ingredient in AOSP, in order to use it, we need to first clone the repo from here: https://android.googlesource.com/platform/frameworks/volley

And then we should import it as a Libarary project into our current project, or import it as a `.jar` file

However, according to the tutorial [here](http://developer.android.com/training/volley/index.html), the official training only covers how to use it in ADT
and the generating the `.jar` is missing(or invalid URL)


##Steps

To apply it in our Android Wear project, we have to make sure that:

* Android Wear *fully* support the AOSP, otherwise some libararies it depends may not work well, this needs some intense testing
* Figure out how to import it as a libarary to our wear application, since Volley iteself is just a project, we need to make it working in our project


TO achieve these two targets, we need to first figure out the second one, and then test it with some test case, there are two ways for the second one:

* import as libarary, then it's source code visible in our project
* import as `.jar` package, then we need to add external `.jar` package to our project.

**_First try_**: for the first method, I tried to import it but it seems that Android Studio behaves poorly on importing repos, and there is no good way or
option to import as libarary project, so there are tons of errors in the new project, I have to give up in this way.

**_Second try_**: this method seems easy, but at first we should know how Android Studio generates the `.jar` package. Luckily, after some try and error,
we can get the `classes.jar` under the folder `volley/build/intermediates/bundles/debug`, then in our wear project, create a new folder named `libs`,
copy the `classes.jar` to the folder, rename it to `volley.jar`, and then in Android Studio, click the project view and select the `volley.jar`, import
it as external library(This option must be carefully checked!)

After the second try, we can make it build well and use the API from volley, the next step should be testing the API and its functionalities in our project

##Some words

Acutually Android Studio is resource-consuming, slow, and UI-*unfriendly*, so sometimes it's hard to find some options there, even though it takes time,
keep Googling for some answers that meets our need.

##Reference

Volley Doc: http://developer.android.com/training/volley/index.html
