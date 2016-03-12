module.exports = function(config) {
    config.set({
 
        // base path, that will be used to resolve files and exclude
        basePath: 'test',
 
        // frameworks to use
        frameworks: ['jasmine'],
 
        // list of files / patterns to load in the browser
        files: [
            'js/angular/home.test.js'
        ],
 
        // list of files to exclude
        exclude: [
        ],
 
        // test results reporter to use
        reporters: ['progress', 'html'],
        
        htmlReporter: {
            outputFile: 'tests/units.html',
      			
            // Optional 
            pageTitle: 'Unit Tests',
            subPageTitle: 'A sample project description'
          },
 
        // web server port
        port: 9876,
 
        // enable / disable colors in the output (reporters and logs)
        colors: false,
 
        // level of logging
        logLevel: config.LOG_INFO,
 
        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: false,
 
        // Start these browsers
        browsers: ['PhantomJS'],
 
        // If browser does not capture in given timeout [ms], kill it
        captureTimeout: 60000,
 
        // Continuous Integration mode
        // if true, it capture browsers, run tests and exit
        singleRun: true
    });
};