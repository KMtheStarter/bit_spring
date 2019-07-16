/**
 * Ajax 통신과 관련된 라이브러리
 */
var httpRequest = null;

function getXMLHttpRequest() {
	if (window.XMLHttpRequest)
		return new XMLHttpRequest;
	if (window.ActiveXObject)
		return new ActiveXObject("microsoft.XMLHTTP");
	return null;
}

function sendProcess(method, url, params, callback) {
	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = callback;

	var httpMethod = method.toUpperCase();
	if (httpMethod != "GET" && httpMethod != "POST")
		httpMethod = "GET";
		
	var httpParams = "";
	if (params != null && params != "") {
		for (var e in params) {
			if (httpParams)
				httpParams += "&";
			httpParams += e + "=" + encodeURIComponent(params[e]);
		}
	}
	console.log(httpParams);

	var httpUrl = url;
	if (httpMethod == "GET")
		httpUrl += "?" + httpParams;
	
	httpRequest.open(httpMethod, httpUrl, true);
	if (httpMethod == "POST")
		httpRequest.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
	httpRequest.send(httpMethod == "GET" ? null : httpParams);
}

function sendProcess_v0(method, url, params, callback) {
	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = callback;

	var httpMethod = method.toUpperCase();
	if (httpMethod != "GET" && httpMethod != "POST")
		httpMethod = "GET";

	var httpParams = encodeURIComponent(params); // 인코딩하면 &가 사라지는 문제가 있다.
	var httpUrl = url;
	if (httpMethod == "GET")
		httpUrl += "?" + params;

	httpRequest.open(httpMethod, httpUrl, true);
	if (httpMethod == "POST")
		httpRequest.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
	httpRequest.send(httpMethod == "GET" ? null : httpParams);
}