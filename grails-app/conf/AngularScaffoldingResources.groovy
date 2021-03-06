import grails.util.GrailsUtil

def fileVersion = GrailsUtil.isDevelopmentEnv() ? '1.0.6' : '1.0.6.min'

modules = {

    angular {
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js/angular', file: "angular-${fileVersion}.js"], nominify: true
    }

    'angular-resource' {
        dependsOn 'angular'
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js/angular', file: "angular-resource-${fileVersion}.js"], nominify: true
    }

    'angular-scaffolding' {
        dependsOn 'angular-resource'
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js/angular', file: "angular-ui.js"], nominify: true
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'scaffolding.js']
        resource id: 'css', url: [plugin: 'angular-scaffolding', dir: 'css', file: 'angular-ui.css']
        resource id: 'css', url: [plugin: 'angular-scaffolding', dir: 'css', file: 'scaffolding.css']
    }

	'angular-grails-default' {
		dependsOn 'angular-scaffolding'
		resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'grails-default.js']
	}

	'angular-grails-resource' {
		dependsOn 'angular-scaffolding'
		resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'grails-resource.js']
	}
}