const staticCacheName = 'site-static-v1';
const assets = [
  'https://jadenfurtado.github.io/Blossom/js/config.js',
  'https://jadenfurtado.github.io/Blossom/css/login.css',
  'https://jadenfurtado.github.io/Blossom/style.css',
  'https://jadenfurtado.github.io/Blossom/Breakdancer.glb',
  'https://fonts.googleapis.com/css?family=Lato:300,400,700',
];
// install event
self.addEventListener('install', evt => {
  evt.waitUntil(
    caches.open(staticCacheName).then((cache) => {
      console.log('caching shell assets');
      cache.addAll(assets);
    })
  );
});
// activate event
self.addEventListener('activate', evt => {
  evt.waitUntil(
    caches.keys().then(keys => {
      return Promise.all(keys
        .filter(key => key !== staticCacheName)
        .map(key => caches.delete(key))
      );
    })
  );
});
// fetch event
self.addEventListener('fetch', evt => {
  evt.respondWith(
    caches.match(evt.request).then(cacheRes => {
      return cacheRes || fetch(evt.request);
    })
  );
});