class Hello{
	public static void main(String[] args)app.LoadPlugin( "Processing" );
  
  
function OnStart()
{
    //Lock screen orientation to Landscape.
    app.SetOrientation( "Landscape" );
    
    //Set full screen game mode.
    app.SetScreenMode( "Game" );
    
    //Create main layout.
    lay = app.CreateLayout( "Linear", "VCenter,FillXY" );
    
    //Create Processing control.
    proc = app.CreateProcessing( 1, 1 );
    lay.AddChild( proc );
    
    //Load the processing sketch.
    proc.LoadSketch( "sketch.txt" );
    
    //Add layout to app
    app.AddLayout( lay );
}
	 
CreateCameraView
Content:
- Methods

CameraViews are used to access the device camera.

cam = app.CreateCameraView( width, height, options ) → app object: CameraView
You can use the “Front” option to show the front camera instead of the default back camera.

The camera needs some time to initialize first.
You can define a callback function via SetOnReady which is called if the camera can be used.
There you have to to call the StartPreview function of the CameraView control to start the preview.

 
The basic functionality of the camera control is taking pictures or recording video.

 
 
But it provides advanced image processing functions as well. These are color reporting, motion detection and face recognision.

 
More samples can be found in the samples section of DroidScript.

Methods
The following methods are available on the CameraView object:

AdjustColor( hue, saturation, brightness, contrast )
Animate( type, callback, time )
AutoCapture( path, fileName, maxCount )
Batch( properties )
ClearFocus()
FindFaces( maxCount ) → Object: { confidence, eyeDistance, midPoint:{ x, y}, pose }
Focus()
GetAbsHeight() → Number: integer
GetAbsWidth() → Number: integer
GetCameraCount() → Number: integer
GetColorEffects() → String: “none”, “mono”, “negative”, “solarize”, “sepia”, “posterize”, “whiteboard”, “blackboard”, “aqua”, “vage-cold”, “point-blue”, “point-red-yellow”, “emboss”, “sketch”, “neon”
GetHeight( options ) → Number
GetImageHeight() → Number: fraction (0..1)
GetImageWidth() → Number: fraction (0..1)
GetLeft( options ) → Number
GetMaxZoom() → Number
GetParameters() → String: semicolon “;” separated: “key1=value1;key2=value2;...”
GetParent() → app object
GetPictureSizes() → String: comma “,” separated: “w1 x h1,w2 x h2,...”
GetPixelData( format, left, top, width, height ) → String: base64 encoded
GetPosition( options ) → Object: { left, top, width, height }
GetTop( options ) → Number
GetType() → String: “CameraView”
GetVisibility() → String: “Show” or “Hide” or “Gone”
GetWidth( options ) → Number
GetZoom() → Number
Gone()
HasFlash() → Boolean
Hide()
IsEnabled() → Boolean
IsOverlap( obj, depth ) → Boolean
IsRecording() → Boolean
IsVisible() → Boolean
Method( name, types, p1, p2, p3, p4 ) → all types
MotionMosaic( xtiles, ytiles, sensitivity, minPeriod, image )
Record( file, seconds )
ReportColors( list, callback, sampSize, maxRate )
SetBackAlpha( alpha )
SetBackColor( color )
SetBackGradient( color1, color2, color3, options )
SetBackGradientRadial( x, y, radius, color1, color2, color3, options )
SetBackground( file, options )
SetColorEffect( effect )
SetColorFilter( color, mode )
SetDescription( desc )
SetDuplicateImage( image1, image2 )
SetEnabled( enable )
SetFlash( onoff )
SetFocusMode( mode )
SetMargins( left, top, right, bottom, mode )
SetOnFocus( callback )
SetOnPicture( callback )
SetOnReady( callback )
SetOrientation( angle )
SetPadding( left, top, right, bottom, mode )
SetParameter( name, value )
SetPictureSize( width, height )
SetPosition( left, top, width, height, options )
SetPostRotation( angle )
SetPreviewImage( image )
SetScale( x, y )
SetSize( width, height, options )
SetSound( enabled )
SetVideoSize( width, height )
SetVisibility( mode )
SetZoom( level )
Show()
StartPreview()
Stop()
StopPreview()
Stream( ip, port, quality, fps, mtu )
TakePicture( file )
Tween( target, duration, type, repeat, yoyo, callback )
Boolean
app object
Number
Object
String
unknown
Number: angle in degrees (0..360)
Number: factor
Number: frames per second
Number: fraction (0..1)
Number: integer
Number: milliseconds
Number: maximum transmission unit
Number: percent
Number: pixel
Number: seconds
Number: -180..180
Number: -100..100
Number: 0..100
Number: 0..0.99 or 1..256
Number: angle in degrees (0..360): 0 or 90 or 180 or 270
String:
  hexadecimal: “#rrggbb”, “#aarrggbb”
  colourName: “red”, “green”, ...
String: comma “,” separated
String: path to folder ( “/absolute/...” or “relative/...” )
String: path to file ( “/absolute/...” or “relative/...” )
String: comma “,” separated: “Front”, “UseBitmap”, “UseABGR”, “NoRotate”, “<id>”, “<resolution>”
String: “NewsPaper” or “Jelly” or “Flash” or “RubberBand” or “Swing” or “TaDa” or “Bounce” or “Fall” or “FallRotate” or “
”
String: “File_n#_motion”
String: “px”
String: “GrayScale” or “JSON” or “<resolution>” or “rawbase64” or “pngbase64” or “jpgbase64”
String: “screen”, “px”
String: pipe “|” separated: “x1,y1|x2,y2|...”
String: “left-right” or “right-left” or “top-bottom” or “bottom-top” or “bl-tr” or “br-tl” or “tl-br” or “tr-bl”
String: “repeat”
String: “none” or “mono” or “negative” or “solarize” or “sepia” or “posterize” or “whiteboard” or “blackboard” or “aqua” or “vage-cold” or “point-blue” or “point-red-yellow” or “emboss” or “sketch” or “neon”
String: “Add” or “Multiply” or “clear” or “darken” or “lighten” or “overlay” or “screen” or “xor” or “color” or “color_burn” or “color_dodge” or “difference” or “exclusion” or “hard_light” or “hue” or “luminosity” or “modulate” or “saturation” or “soft_light” or “src” or “dst” or “src_in” or “src_out” or “src_atop” or “src_over” or “dst_in” or “dst_out” or “dst_atop” or “dst_over”
String: “Auto” or “Picture” or “Video” or “Macro” or “EDOF” or “Fixed” or “Infinity”
String: “px” or “sp” or “dip” or “mm” or “pt”
String: “px” or “sp” or “dip” or “dp” or “mm” or “pt”
String: “Show” or “Hide” or “Gone”
String: “Linear.None” or “Quadratic.In/Out” or “Cubic.In/Out” or “Quartic.In/Out” or “Quintic.In/Out” or “Sinusoidal.In/Out” or “Exponential.In/Out” or “Circular.In/Out” or “Elastic.In/Out” or “Back.In/Out” or “Bounce.In/Out”
Number
String
Object: { COMMAND }
Object: { x, y, w, h, sw, sh, rot }
app object: Image
List: boolean,char,byte,short,int,long,float,double,String,CharSequence,...
List: [[r1,g1,b1], [r2,g2,b2], ...]
function( type )
function( data )
function()
function( file )
cam.AdjustColor
Adjust the visual color effect of the control by setting the Hue (by angle in degrees in a color circle), the saturation, brightness and contrast of the control.
cam.Animate
Animates the control.

There are
    “in”-Animations which are used to show objects from hidden state
    “out”-animations which are used to hide objects in visible state and
    “static”-animations which keep the visible state.
cam.AutoCapture
Automatically takes pictures if a motion was detected by cam.MotionMosaic.
The first # in the filename is a placeholder for numbers increasing for every taken picture.
cam.Batch
Batch method calls to be able to set all object's properties at once.
Note that you need to specify each parameter (use “” or null to leave some out)
Inherited methods can be called by appending an underscore to the function name (ie. txt.Batch({ SetBackColor_: [“red”] })
cam.ClearFocus
Removes the focus of the control so that the user no longer has immediate access to it.
cam.FindFaces
Finds faces in the current camera view.
cam.Focus
Set the focus to the control so that the user can interact with it immediately.
cam.GetAbsHeight
Get the absolute height of the control in pixels.
Note that unlike the objects margins its padding does change this value.
cam.GetAbsWidth
Get the absolute width of the control in pixels.
Note that unlike the objects margins its padding does change this value.
cam.GetCameraCount
Returns the amount of cameras built in to the device.
cam.GetColorEffects
Returns a list of available color effects for the camera.
cam.GetHeight
Get the height of the control as screen height relative float or in pixels with the px option.
Note that unlike the objects margins its padding does change this value.
cam.GetImageHeight
Returns the camera capture height in pixels.
cam.GetImageWidth
Returns the camera capture width in pixels.
cam.GetLeft
Get the distance from the control to the left parent border as width relative float or in pixels with the px option.
cam.GetMaxZoom
Returns the hightst possible zoom value.
cam.GetParameters
Get properties, possible values and settings of the camera as “key=value; pairs.
cam.GetParent
Returns the parent control object where the object was added to - commonly a layout.
cam.GetPictureSizes
Returns a list of possible picture dimensions.
cam.GetPixelData
Returns the current camera's raw, png or jpg image datas encoded as base64.
cam.GetPosition
Returns data about the position and size of the control.
If the screen option is given the position on the screen will be returned. Otherwise relative to the parent control.
The px options turns the relative values into pixels.
cam.GetTop
Get the distance from the control to the upper parent border as height relative float or in pixels with the px option.
cam.GetType
Returns the control class name.
cam.GetVisibility
Returns the current visibility state of the control. The Values are:
Show: visible
Hide: invisible but still consuming space
Gone: invisible and not consuming space
cam.GetWidth
Get the width of the control as screen width relative float or in pixels with the px option.
Note that unlike the objects margins its padding does change this value.
cam.GetZoom
Returns the curent zoom value.
cam.Gone
Hides the control without consuming any more layout space as if it were never there.
cam.HasFlash
Checks if the currently used camera has a camera flash.
cam.Hide
Hide the control but keep the layout space free.
cam.IsEnabled
Returns whether the control is currently useable by the user.
cam.IsOverlap
Returns whether the control overlaps with another by a given distance.
cam.IsRecording
Returns a boolea indicating whether the camera is currently recording a video.
cam.IsVisible
Returns whether the control is currently visible to the user, ignoring overlaying controls.
cam.Method
Allows access to other functions defined on the object in Java via reflection.

Note: This function is a premium feature. Please consider subscribing to Premium to use this feature and support DroidScript in its further development.
cam.MotionMosaic
Defines a raster which is used for motion detection.
Use AutoCapture to take pictures if a motion was detected.
cam.Record
Record a video to a given file. If seconds is specified, the recording will automatically stop after this time. Otherwise call cam.Stop().
cam.ReportColors
Keeps tracks of the average color around a given point.
cam.SetBackAlpha
Set the transparency of the background by an alpha value between 0 (no transparency) and 0.99 (full transparent) or 1 (no transparency) and 256 (full transparent)
cam.SetBackColor
Changes the background color of the control.
cam.SetBackGradient
Define the background color of the control with a gradient. The default gradient direction is from top to bottom, but you can change it from left to right and the reversed versions of course.
cam.SetBackGradientRadial
Define a radial color gradient for the background of control.
cam.SetBackground
Changes the background to an image which can be repeated using the repeat option.
An image which is often used with that option is '/res/drawable/pattern_carbon' - try it out!
cam.SetColorEffect
Applies a color effect to the camera.
cam.SetColorFilter
Adjust the visual color effect with a color and a given BlendMode. More information about BlendMode can be found in the Android Developer page.
cam.SetDescription
Set a control description for accessibility
cam.SetDuplicateImage
Define two CreateImage controls where the camera view is duplicated to. This method may be used for cardboart AR. Have a look at Daves forum post about that method.
cam.SetEnabled
En/Disable the control physically and visually so that the user can/can not access the control. Events like OnTouch will still be fired.
cam.SetFlash
En- or disables the camera flash if available.
cam.SetFocusMode
Change the cameras focus mode depending  on the purpose.
cam.SetMargins
Define a distance to other controls on each side of the control.
cam.SetOnFocus
Define a callback function called when the user focuses the control.
cam.SetOnPicture
Defines a callback function which is called if cam.AutoCapture took a picture. The file parameter contains the path to the image file.
cam.SetOnReady
Defines a callback function which is called when the camera is ready for use.
cam.SetOrientation
Rotates the camera view.
cam.SetPadding
Define distances that elements within the control are to maintain from the control borders.
cam.SetParameter
Change property values of the camera.
See GetProperties to get a full list of available keys.
cam.SetPictureSize
Define a custom picture size in pixels.
cam.SetPosition
Defines the position and size for the control if the parent is an absolute layout.
cam.SetPostRotation
Rotates captured image in any desired angle in degrees.
cam.SetPreviewImage
Defines an image control which will show the captured picture automatically when taken.
cam.SetScale
Scales the control along with its contents by the factors passed to the function.
cam.SetSize
Change the size of the control in either screen relative values or in pixels if the px option was given.
cam.SetSound
En-/Disables the camera sound playing when taking pictures.
cam.SetVideoSize
Define a custom video recording size in pixels.
cam.SetVisibility
Change the visibility of the control to one of the available modes:
Show: visible
Hide: invisible but still consuming space
Gone: invisible and not consuming space
cam.SetZoom
Change the zoom value of the camera.
cam.Show
Set the visibility of the control to “Show”.
cam.StartPreview
Start the camera preview on the display.
cam.Stop
Stop recording a video.
cam.StopPreview
Stop the camera preview on the display.
cam.Stream
Streams the camera view to a local ip.
cam.TakePicture
Takes a picture of the current view and saves it to a file.
cam.Tween
Performs an animation on the control.
The target object is for the position, size and rotation that the control has at the end of the animation.

The type specifies the behavior and the speed of the animation. Separated by a dot, you must also specify whether you want to apply this behavior to the beginning (In), end (Out), or to both (InOut) times of the animation.

With the amount of repeats you can control how many times you want to play the animation.

If you have jojo activated, the animation will alternate between forward and backward playback, so that if the repetition value is odd, the control will be at the start position again at the end of the animation.
 
CreateCameraView
Content:
- Methods

CameraViews are used to access the device camera.

cam = app.CreateCameraView( width, height, options ) → app object: CameraView
You can use the “Front” option to show the front camera instead of the default back camera.

The camera needs some time to initialize first.
You can define a callback function via SetOnReady which is called if the camera can be used.
There you have to to call the StartPreview function of the CameraView control to start the preview.

 
The basic functionality of the camera control is taking pictures or recording video.

 
 
But it provides advanced image processing functions as well. These are color reporting, motion detection and face recognision.

 
More samples can be found in the samples section of DroidScript.

Methods
The following methods are available on the CameraView object:

AdjustColor( hue, saturation, brightness, contrast )
Animate( type, callback, time )
AutoCapture( path, fileName, maxCount )
Batch( properties )
ClearFocus()
FindFaces( maxCount ) → Object: { confidence, eyeDistance, midPoint:{ x, y}, pose }
Focus()
GetAbsHeight() → Number: integer
GetAbsWidth() → Number: integer
GetCameraCount() → Number: integer
GetColorEffects() → String: “none”, “mono”, “negative”, “solarize”, “sepia”, “posterize”, “whiteboard”, “blackboard”, “aqua”, “vage-cold”, “point-blue”, “point-red-yellow”, “emboss”, “sketch”, “neon”
GetHeight( options ) → Number
GetImageHeight() → Number: fraction (0..1)
GetImageWidth() → Number: fraction (0..1)
GetLeft( options ) → Number
GetMaxZoom() → Number
GetParameters() → String: semicolon “;” separated: “key1=value1;key2=value2;...”
GetParent() → app object
GetPictureSizes() → String: comma “,” separated: “w1 x h1,w2 x h2,...”
GetPixelData( format, left, top, width, height ) → String: base64 encoded
GetPosition( options ) → Object: { left, top, width, height }
GetTop( options ) → Number
GetType() → String: “CameraView”
GetVisibility() → String: “Show” or “Hide” or “Gone”
GetWidth( options ) → Number
GetZoom() → Number
Gone()
HasFlash() → Boolean
Hide()
IsEnabled() → Boolean
IsOverlap( obj, depth ) → Boolean
IsRecording() → Boolean
IsVisible() → Boolean
Method( name, types, p1, p2, p3, p4 ) → all types
MotionMosaic( xtiles, ytiles, sensitivity, minPeriod, image )
Record( file, seconds )
ReportColors( list, callback, sampSize, maxRate )
SetBackAlpha( alpha )
SetBackColor( color )
SetBackGradient( color1, color2, color3, options )
SetBackGradientRadial( x, y, radius, color1, color2, color3, options )
SetBackground( file, options )
SetColorEffect( effect )
SetColorFilter( color, mode )
SetDescription( desc )
SetDuplicateImage( image1, image2 )
SetEnabled( enable )
SetFlash( onoff )
SetFocusMode( mode )
SetMargins( left, top, right, bottom, mode )
SetOnFocus( callback )
SetOnPicture( callback )
SetOnReady( callback )
SetOrientation( angle )
SetPadding( left, top, right, bottom, mode )
SetParameter( name, value )
SetPictureSize( width, height )
SetPosition( left, top, width, height, options )
SetPostRotation( angle )
SetPreviewImage( image )
SetScale( x, y )
SetSize( width, height, options )
SetSound( enabled )
SetVideoSize( width, height )
SetVisibility( mode )
SetZoom( level )
Show()
StartPreview()
Stop()
StopPreview()
Stream( ip, port, quality, fps, mtu )
TakePicture( file )
Tween( target, duration, type, repeat, yoyo, callback )
Boolean
app object
Number
Object
String
unknown
Number: angle in degrees (0..360)
Number: factor
Number: frames per second
Number: fraction (0..1)
Number: integer
Number: milliseconds
Number: maximum transmission unit
Number: percent
Number: pixel
Number: seconds
Number: -180..180
Number: -100..100
Number: 0..100
Number: 0..0.99 or 1..256
Number: angle in degrees (0..360): 0 or 90 or 180 or 270
String:
  hexadecimal: “#rrggbb”, “#aarrggbb”
  colourName: “red”, “green”, ...
String: comma “,” separated
String: path to folder ( “/absolute/...” or “relative/...” )
String: path to file ( “/absolute/...” or “relative/...” )
String: comma “,” separated: “Front”, “UseBitmap”, “UseABGR”, “NoRotate”, “<id>”, “<resolution>”
String: “NewsPaper” or “Jelly” or “Flash” or “RubberBand” or “Swing” or “TaDa” or “Bounce” or “Fall” or “FallRotate” or “
”
String: “File_n#_motion”
String: “px”
String: “GrayScale” or “JSON” or “<resolution>” or “rawbase64” or “pngbase64” or “jpgbase64”
String: “screen”, “px”
String: pipe “|” separated: “x1,y1|x2,y2|...”
String: “left-right” or “right-left” or “top-bottom” or “bottom-top” or “bl-tr” or “br-tl” or “tl-br” or “tr-bl”
String: “repeat”
String: “none” or “mono” or “negative” or “solarize” or “sepia” or “posterize” or “whiteboard” or “blackboard” or “aqua” or “vage-cold” or “point-blue” or “point-red-yellow” or “emboss” or “sketch” or “neon”
String: “Add” or “Multiply” or “clear” or “darken” or “lighten” or “overlay” or “screen” or “xor” or “color” or “color_burn” or “color_dodge” or “difference” or “exclusion” or “hard_light” or “hue” or “luminosity” or “modulate” or “saturation” or “soft_light” or “src” or “dst” or “src_in” or “src_out” or “src_atop” or “src_over” or “dst_in” or “dst_out” or “dst_atop” or “dst_over”
String: “Auto” or “Picture” or “Video” or “Macro” or “EDOF” or “Fixed” or “Infinity”
String: “px” or “sp” or “dip” or “mm” or “pt”
String: “px” or “sp” or “dip” or “dp” or “mm” or “pt”
String: “Show” or “Hide” or “Gone”
String: “Linear.None” or “Quadratic.In/Out” or “Cubic.In/Out” or “Quartic.In/Out” or “Quintic.In/Out” or “Sinusoidal.In/Out” or “Exponential.In/Out” or “Circular.In/Out” or “Elastic.In/Out” or “Back.In/Out” or “Bounce.In/Out”
Number
String
Object: { COMMAND }
Object: { x, y, w, h, sw, sh, rot }
app object: Image
List: boolean,char,byte,short,int,long,float,double,String,CharSequence,...
List: [[r1,g1,b1], [r2,g2,b2], ...]
function( type )
function( data )
function()
function( file )
cam.AdjustColor
Adjust the visual color effect of the control by setting the Hue (by angle in degrees in a color circle), the saturation, brightness and contrast of the control.
cam.Animate
Animates the control.

There are
    “in”-Animations which are used to show objects from hidden state
    “out”-animations which are used to hide objects in visible state and
    “static”-animations which keep the visible state.
cam.AutoCapture
Automatically takes pictures if a motion was detected by cam.MotionMosaic.
The first # in the filename is a placeholder for numbers increasing for every taken picture.
cam.Batch
Batch method calls to be able to set all object's properties at once.
Note that you need to specify each parameter (use “” or null to leave some out)
Inherited methods can be called by appending an underscore to the function name (ie. txt.Batch({ SetBackColor_: [“red”] })
cam.ClearFocus
Removes the focus of the control so that the user no longer has immediate access to it.
cam.FindFaces
Finds faces in the current camera view.
cam.Focus
Set the focus to the control so that the user can interact with it immediately.
cam.GetAbsHeight
Get the absolute height of the control in pixels.
Note that unlike the objects margins its padding does change this value.
cam.GetAbsWidth
Get the absolute width of the control in pixels.
Note that unlike the objects margins its padding does change this value.
cam.GetCameraCount
Returns the amount of cameras built in to the device.
cam.GetColorEffects
Returns a list of available color effects for the camera.
cam.GetHeight
Get the height of the control as screen height relative float or in pixels with the px option.
Note that unlike the objects margins its padding does change this value.
cam.GetImageHeight
Returns the camera capture height in pixels.
cam.GetImageWidth
Returns the camera capture width in pixels.
cam.GetLeft
Get the distance from the control to the left parent border as width relative float or in pixels with the px option.
cam.GetMaxZoom
Returns the hightst possible zoom value.
cam.GetParameters
Get properties, possible values and settings of the camera as “key=value; pairs.
cam.GetParent
Returns the parent control object where the object was added to - commonly a layout.
cam.GetPictureSizes
Returns a list of possible picture dimensions.
cam.GetPixelData
Returns the current camera's raw, png or jpg image datas encoded as base64.
cam.GetPosition
Returns data about the position and size of the control.
If the screen option is given the position on the screen will be returned. Otherwise relative to the parent control.
The px options turns the relative values into pixels.
cam.GetTop
Get the distance from the control to the upper parent border as height relative float or in pixels with the px option.
cam.GetType
Returns the control class name.
cam.GetVisibility
Returns the current visibility state of the control. The Values are:
Show: visible
Hide: invisible but still consuming space
Gone: invisible and not consuming space
cam.GetWidth
Get the width of the control as screen width relative float or in pixels with the px option.
Note that unlike the objects margins its padding does change this value.
cam.GetZoom
Returns the curent zoom value.
cam.Gone
Hides the control without consuming any more layout space as if it were never there.
cam.HasFlash
Checks if the currently used camera has a camera flash.
cam.Hide
Hide the control but keep the layout space free.
cam.IsEnabled
Returns whether the control is currently useable by the user.
cam.IsOverlap
Returns whether the control overlaps with another by a given distance.
cam.IsRecording
Returns a boolea indicating whether the camera is currently recording a video.
cam.IsVisible
Returns whether the control is currently visible to the user, ignoring overlaying controls.
cam.Method
Allows access to other functions defined on the object in Java via reflection.

Note: This function is a premium feature. Please consider subscribing to Premium to use this feature and support DroidScript in its further development.
cam.MotionMosaic
Defines a raster which is used for motion detection.
Use AutoCapture to take pictures if a motion was detected.
cam.Record
Record a video to a given file. If seconds is specified, the recording will automatically stop after this time. Otherwise call cam.Stop().
cam.ReportColors
Keeps tracks of the average color around a given point.
cam.SetBackAlpha
Set the transparency of the background by an alpha value between 0 (no transparency) and 0.99 (full transparent) or 1 (no transparency) and 256 (full transparent)
cam.SetBackColor
Changes the background color of the control.
cam.SetBackGradient
Define the background color of the control with a gradient. The default gradient direction is from top to bottom, but you can change it from left to right and the reversed versions of course.
cam.SetBackGradientRadial
Define a radial color gradient for the background of control.
cam.SetBackground
Changes the background to an image which can be repeated using the repeat option.
An image which is often used with that option is '/res/drawable/pattern_carbon' - try it out!
cam.SetColorEffect
Applies a color effect to the camera.
cam.SetColorFilter
Adjust the visual color effect with a color and a given BlendMode. More information about BlendMode can be found in the Android Developer page.
cam.SetDescription
Set a control description for accessibility
cam.SetDuplicateImage
Define two CreateImage controls where the camera view is duplicated to. This method may be used for cardboart AR. Have a look at Daves forum post about that method.
cam.SetEnabled
En/Disable the control physically and visually so that the user can/can not access the control. Events like OnTouch will still be fired.
cam.SetFlash
En- or disables the camera flash if available.
cam.SetFocusMode
Change the cameras focus mode depending  on the purpose.
cam.SetMargins
Define a distance to other controls on each side of the control.
cam.SetOnFocus
Define a callback function called when the user focuses the control.
cam.SetOnPicture
Defines a callback function which is called if cam.AutoCapture took a picture. The file parameter contains the path to the image file.
cam.SetOnReady
Defines a callback function which is called when the camera is ready for use.
cam.SetOrientation
Rotates the camera view.
cam.SetPadding
Define distances that elements within the control are to maintain from the control borders.
cam.SetParameter
Change property values of the camera.
See GetProperties to get a full list of available keys.
cam.SetPictureSize
Define a custom picture size in pixels.
cam.SetPosition
Defines the position and size for the control if the parent is an absolute layout.
cam.SetPostRotation
Rotates captured image in any desired angle in degrees.
cam.SetPreviewImage
Defines an image control which will show the captured picture automatically when taken.
cam.SetScale
Scales the control along with its contents by the factors passed to the function.
cam.SetSize
Change the size of the control in either screen relative values or in pixels if the px option was given.
cam.SetSound
En-/Disables the camera sound playing when taking pictures.
cam.SetVideoSize
Define a custom video recording size in pixels.
cam.SetVisibility
Change the visibility of the control to one of the available modes:
Show: visible
Hide: invisible but still consuming space
Gone: invisible and not consuming space
cam.SetZoom
Change the zoom value of the camera.
cam.Show
Set the visibility of the control to “Show”.
cam.StartPreview
Start the camera preview on the display.
cam.Stop
Stop recording a video.
cam.StopPreview
Stop the camera preview on the display.
cam.Stream
Streams the camera view to a local ip.
cam.TakePicture
Takes a picture of the current view and saves it to a file.
cam.Tween
Performs an animation on the control.
The target object is for the position, size and rotation that the control has at the end of the animation.

The type specifies the behavior and the speed of the animation. Separated by a dot, you must also specify whether you want to apply this behavior to the beginning (In), end (Out), or to both (InOut) times of the animation.

With the amount of repeats you can control how many times you want to play the animation.

If you have jojo activated, the animation will alternate between forward and backward playback, so that if the repetition value is odd, the control will be at the start position again at the end of the animation.

Finally the callback function will be called after the animation has finished. Well, it's about time!
Finally the callback function will be called after the animation has finished. Well, it's about time! {
	  	System.out.println("Hello jdk!!!");
	}
}
