## MultiTouch-Android
Example of multi touch image for android (drag/zoom/rotate)
![Example](https://raw.githubusercontent.com/nikartm/AndroidUsefulExamples/master/screenshots/multi_touch.gif)

## Google Calendar Event
Example Google API Calendar Event
![Example](https://raw.githubusercontent.com/nikartm/AndroidUsefulExamples/master/screenshots/calendar_event.gif)

For development you need to create or select project in the [GDC](https://console.developers.google.com/flows/enableapi?apiid=calendar)

*If you need get SHA1 to enable the API use on Windows:*
```
keytool -list -v -keystore "C:\Users\user_name\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
```
*On unix:*
```
keytool -exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v
```
## Drag And Drop, Swipe
Example drag and drop and swipe CardView for RecycleView
![Example](https://raw.githubusercontent.com/nikartm/AndroidUsefulExamples/master/screenshots/drag_and_drop_swipe.gif)
