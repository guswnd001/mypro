var httpRequest = null;

function sendRequest(url, params, callback, method) {
	httpRequest = new XMLHttpRequest();
	method = method.toUpperCase();
	if (method != 'POST') { method = 'GET';	}
	if (method == 'GET') { url = url + '?' + params; }
	httpRequest.open(method, url, true);
	//post 방식때 필요함
	httpRequest.setRequestHeader(
			'Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	httpRequest.send(method == 'POST'? params : null);
}