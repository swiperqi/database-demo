<template>
	<div id="app">
		<img alt="Vue logo" src="./assets/logo.png">
		<!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
		<DatabaseDemo class="databaseDemo"></DatabaseDemo>
	</div>
</template>

<script>
	import HelloWorld from './components/HelloWorld.vue'
	import DatabaseDemo from './components/databaseDemo/DatabaseDemo.vue'

	export default {
		name: 'app',
		components: {
			HelloWorld,
			DatabaseDemo
		}
	}
</script>

<style>
	#app {
		font-family: 'Avenir', Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
		margin-top: 60px;
	}

	.databaseDemo {
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
	}
</style>
