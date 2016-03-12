// including plugins
var gulp = require('gulp')
var sass = require('gulp-sass');
var concatCss = require('gulp-concat-css');
var path = require('path');
var es = require('event-stream');
var inject = require('gulp-inject');

var onlyDirs = function (es) {
  return es.map(function (file, cb) {
    if (file.stat.isFile()) {
      return cb(null, file);
    } else {
      return cb();
    }
  });
};





gulp.task('sass', function () {
  return gulp.src('./src/main/resources/static/app/assets/**/*.scss')
    .pipe(sass().on('error', sass.logError))
    .pipe(concatCss("styles/external.css"))
    .pipe(gulp.dest('./src/main/resources/static/build/assets'));
});

gulp.task('assets', function () {
  return gulp.src([
        path.join('src/main/resources/static/app/assets/font-awesome-4.5.0/', '**'),
        path.join('src/main/resources/static/app', '**'),
        '!' + path.join('src/main/resources/static/app', '**', '*.ts'),
        '!' + path.join('src/main/resources/static/app', '**', '*.css'),
        '!' + path.join('src/main/resources/static/app', '**', '*.html'),
        '!' + path.join('src/main/resources/static/app', '**', '*.less'),
        '!' + path.join('src/main/resources/static/app', '**', '*.scss'),
      ])
        .pipe(onlyDirs(es))
      .pipe(gulp.dest('src/main/resources/static/build'));
});

gulp.task('index', function () {
  var target = gulp.src('src/main/resources/static/app/index.html');
  // It's not necessary to read the files (will speed up things), we're only after their paths:
  var sources = gulp.src(['src/main/resources/static/build/**/*js','src/main/resources/static/build/**/*css'], {read: false});

  return target.pipe(inject(sources))
    .pipe(gulp.dest('src/main/resources/static/build/'));
});
