
  ;(function(){
  let u=void 0,isReady=false,onReadyCallbacks=[],isServiceReady=false,onServiceReadyCallbacks=[];
  const __uniConfig = {"pages":[],"globalStyle":{"backgroundColor":"#F8F8F8","navigationBar":{"backgroundColor":"#F8F8F8","titleText":"智控科技","type":"default","titleColor":"#000000"},"isNVue":false},"nvue":{"compiler":"uni-app","styleCompiler":"uni-app","flex-direction":"column"},"renderer":"auto","appname":"智控科技","splashscreen":{"alwaysShowBeforeRender":true,"autoclose":true},"compilerVersion":"3.7.10","entryPagePath":"pages/index/index","entryPageQuery":"","realEntryPagePath":"","networkTimeout":{"request":60000,"connectSocket":60000,"uploadFile":60000,"downloadFile":60000},"tabBar":{"position":"bottom","color":"#2C2C2C","selectedColor":"#07C160","borderStyle":"black","blurEffect":"none","fontSize":"10px","iconWidth":"24px","spacing":"3px","height":"50px","backgroundColor":"#F7F7F7","list":[{"iconPath":"/static/tabbar/home.png","selectedIconPath":"/static/tabbar/home_selected.png","text":"首页","pagePath":"pages/index/index"},{"iconPath":"/static/tabbar/find.png","selectedIconPath":"/static/tabbar/finded.png","text":"发现","pagePath":"pages/function/function"}],"selectedIndex":0,"shown":true},"locales":{},"darkmode":false,"themeConfig":{}};
  const __uniRoutes = [{"path":"pages/index/index","meta":{"isQuit":true,"isEntry":true,"isTabBar":true,"tabBarIndex":0,"enablePullDownRefresh":false,"navigationBar":{"titleText":"智控科技","type":"default"},"isNVue":false}},{"path":"pages/function/function","meta":{"isQuit":true,"isTabBar":true,"tabBarIndex":1,"enablePullDownRefresh":false,"navigationBar":{"titleText":"发现","type":"default"},"isNVue":false}},{"path":"pages/subpages/instruction/instruction","meta":{"enablePullDownRefresh":false,"navigationBar":{"titleText":"","type":"default"},"isNVue":false}},{"path":"pages/subpages/aboutUs/aboutUs","meta":{"enablePullDownRefresh":false,"navigationBar":{"titleText":"","type":"default"},"isNVue":false}}].map(uniRoute=>(uniRoute.meta.route=uniRoute.path,__uniConfig.pages.push(uniRoute.path),uniRoute.path='/'+uniRoute.path,uniRoute));
  __uniConfig.styles=[];//styles
  __uniConfig.onReady=function(callback){if(__uniConfig.ready){callback()}else{onReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"ready",{get:function(){return isReady},set:function(val){isReady=val;if(!isReady){return}const callbacks=onReadyCallbacks.slice(0);onReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
  __uniConfig.onServiceReady=function(callback){if(__uniConfig.serviceReady){callback()}else{onServiceReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"serviceReady",{get:function(){return isServiceReady},set:function(val){isServiceReady=val;if(!isServiceReady){return}const callbacks=onServiceReadyCallbacks.slice(0);onServiceReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
  service.register("uni-app-config",{create(a,b,c){if(!__uniConfig.viewport){var d=b.weex.config.env.scale,e=b.weex.config.env.deviceWidth,f=Math.ceil(e/d);Object.assign(__uniConfig,{viewport:f,defaultFontSize:16})}return{instance:{__uniConfig:__uniConfig,__uniRoutes:__uniRoutes,global:u,window:u,document:u,frames:u,self:u,location:u,navigator:u,localStorage:u,history:u,Caches:u,screen:u,alert:u,confirm:u,prompt:u,fetch:u,XMLHttpRequest:u,WebSocket:u,webkit:u,print:u}}}}); 
  })();
  