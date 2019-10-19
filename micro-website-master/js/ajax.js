//ajax的封装
// var baseURL = 'http://47.104.166.165:8088';
var baseURL = 'localhost:8888';
function getAjax(url,method,data,successFun,errorFun){
	$.ajax({
		url:baseURL+url,
		method:method,
		data:data,
		success:successFun,
		error:errorFun
	});
}