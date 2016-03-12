var webpack = require("webpack");
var CopyWebpackPlugin = require('copy-webpack-plugin');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var path = require('path');

module.exports = {
		entry: {
		        js :"./src/main/resources/static/app/main.ts",
					},
		output: {
			path: "src/main/resources/static/build",
			filename: "js/bundle.js"
		},
		resolve:{
			extensions:['','.js','.ts']
		},
		module:{
			loaders	:[
			       	  {test:/\.ts/,loaders:['ts-loader'],exclude:/node_modules/},
			       	  { test: /\.scss$/, loader: ExtractTextPlugin.extract(
    						"style",  "css!sass")}
			       	 ]
		},
		vendor:"moment/moment.js",
		plugins: [
		          new CopyWebpackPlugin([
		                                 { from: 'node_modules/angular2/bundles/angular2-polyfills.js', to: 'js/3rdparty' },
		                                 { from: 'node_modules/angular2/bundles/router.dev.js', to: 'js/3rdparty' },
		                                 { from: 'node_modules/ng2-bootstrap/bundles/ng2-bootstrap.min.js', to: 'js/3rdparty' },

										 { from: 'src/main/resources/static/app/assets', to: 'assets' }
		                             ] ,{ignore: ['*.scss','*.ts','*.less','*.css']})

		        ]
}
