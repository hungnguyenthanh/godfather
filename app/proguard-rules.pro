# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/HungNT/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# The simpliest strategy is to not run proguard against your project's own code.
# This doesn't provide the benefits of optimization & obfuscation against your
# project, but will still strip the libraries. The advantage is that your app will
# work without any subsequent effort. If you choose this strategy, the proguard
# configuration for the project is simply the line below.

-keep class com.snapsofts.doopapp.** { *; }

# The more involved strategy is to specifically provide rules to keep portions of your
# app's codebase unmodified while allowing proguard to optimize the rest.

# The first decision is whether or not you want to obfuscate your code. This provides no
# performance benefit but makes it harder for other people to read your source code.
# Unfortunately obfuscation can cause issues for code that uses reflection or a few other
# techniques. The default is to obfuscate.

-dontobfuscate

# Butter Knife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson  ----------

## Picasso
-dontwarn com.squareup.okhttp.**
