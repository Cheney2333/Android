<template>
	<view class="content1">
		<button @click="testSocket()">发送指令</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				data: "test"
			}
		},
		methods: {
			
			testSocket() {
				// 创建TCP客户端  
				var client = new WebSocket('ws://8.140.26.4:8088');  
				  
				// 连接到服务器  
				client.onopen = function(event) {  
				  console.log('WebSocket连接已建立');  
				    
				  // 发送消息到服务器  
				  client.send('Hello, server!');  
				    
				  // 接收服务器发送的消息  
				  var received = client.recv();  
				  console.log('Received: ' + received);  
				    
				  // 关闭WebSocket连接  
				  client.close();  
				};  
				  
				// 监听WebSocket连接关闭事件  
				client.onerror = function(event) {  
				  console.log('WebSocket连接发生错误');  
				};  
				  
				// 监听WebSocket连接关闭事件  
				client.onclose = function(event) {  
				  console.log('WebSocket连接已关闭');  
				};
				
				
			}
			

		}
	}
</script>

<style>

</style>
