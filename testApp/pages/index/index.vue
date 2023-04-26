<template>
	<view class="content">
		<image class="logo" src="/static/logo2.png"></image>
		<view class="text1">
			欢迎使用智控科技公司出品的智能外卖储存柜
		</view>
		
		<view class="instruction" @click="leeaTo1">
			<text>使用说明</text>
		</view>
		<view class="aboutUs" @click="leeaTo2">
			<text>关于我们</text>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {

		},
		methods: {
			test: function () {
				uni.showToast({
					title: '测试'
				});
			},
			leeaTo1: function () {
				uni.navigateTo({
					url: "/pages/subpages/instruction/instruction",
					animationType: 'slide-in-right',
					animationDuration: 300
				})
			},
			leeaTo2: function () {
				uni.navigateTo({
					url: "/pages/subpages/aboutUs/aboutUs",
					animationType: 'slide-in-right',
					animationDuration: 300
				})
			}
		}
	}
</script>

<style>
	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 20rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 15rpx;
	}
	.text1 {
		display: flex;
		align-items: center;
		font-size: 17px;
		justify-content: center;
		margin-top: 10px;
	}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	.instruction {
		margin-top: 60rpx;
		margin-bottom: 60rpx;
	}
	
	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
