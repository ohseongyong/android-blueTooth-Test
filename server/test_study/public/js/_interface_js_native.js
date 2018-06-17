	// JavaScript Document

	var _interface_js_native = function () {
	
		return {
			
			_init : function ($return_val) {
				
				//interface Test --> OK!
				//check for Device(iphone or Android)
				console.log("version : " + $return_val);

			},
			load_complete : function () {

				window.Android.showHideSpinner("hide");

			},
			showAndroidToast : function (msg) {

				window.Android.showToast(msg);
				
			},
            disconnected : function () {

                window.Android.disconnected();

            }
			
		};
		
	}();
	
	