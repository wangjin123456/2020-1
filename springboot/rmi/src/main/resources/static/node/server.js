var http=require('http');
http.createServer(function (request,response) {
response.writeHead(200,{'content-Type':'text/plain'});
response.end('hello world\n');
}).listen(8888);
// 终端打印如下信息
console.log('Server running at http://127.0.0.1:8888/');