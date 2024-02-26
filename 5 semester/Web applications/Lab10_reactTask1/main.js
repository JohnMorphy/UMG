import * as THREE from 'three';
// import * as THREE from './node_modules/three/build/three.module.js';

// PARAMETERS
var windowWidth = window.innerWidth
var windowHeight = window.innerHeight

var fieldOfView = 75            // angle view
var aspectRatio = window.innerWidth / windowHeight;
var nearPlane = 0.1             // minimal fov
var farPlane = 100              // maximal zoomout

var ligthCount = 18;

// 1. Create scene
const scene = new THREE.Scene();

// adding light
const color = 0xFFFFFF;
const intensity = 2;

for(let i = 0; i < ligthCount; i++) {
    var light = new THREE.DirectionalLight(color, intensity);
    var angle = 360/ligthCount * i;
    var radians = (angle*Math.PI)/180;
    light.position.set(Math.sin(radians)*10, 1, Math.cos(radians)*10);
    scene.add(light);
}

// ambient light
const ambientColor = 0xFF000AA;
const ambientIntensity = 1;
const ambientLight = new THREE.AmbientLight(ambientColor, ambientIntensity);
scene.add(ambientLight);

// 2. Create camera
const camera = new THREE.PerspectiveCamera(
    fieldOfView, aspectRatio, nearPlane, farPlane
);

camera.position.set(0, 3, 8);
const pt = new THREE.Vector3(0, -2, 0);
camera.lookAt(pt);

function handleKeyPress(event) { // event for moving by using arrow keys
    const moveDistance = 0.5;

    switch (event.code) {
        case 'KeyW':
            camera.position.y += moveDistance;
            break;
        case 'KeyS':
            camera.position.y -= moveDistance;
            break;
        case 'KeyA':
            camera.position.x += moveDistance;
            break;
        case 'KeyD':
            camera.position.x -= moveDistance;
            break;
    }

    camera.lookAt(pt);
}
document.addEventListener('keydown', handleKeyPress);

// 3. Crete renderer
const renderer = new THREE.WebGLRenderer();
renderer.setSize(windowWidth,windowHeight);
document.body.appendChild(renderer.domElement);

// 4. Creating objects for drawing

// creating UFO

const saucerGeometry = new THREE.TorusGeometry(3, 1, 16, 100);
const saucerMaterial = new THREE.MeshPhongMaterial({ color: 0x000000 });
const saucer = new THREE.Mesh(saucerGeometry, saucerMaterial);
saucer.position.set(0, 0, 0);
scene.add(saucer);

const bodyGeometry = new THREE.SphereGeometry(1.5, 32, 32);
const bodyMaterial = new THREE.MeshPhongMaterial({ color: 0x000000 });
const body = new THREE.Mesh(bodyGeometry, bodyMaterial);
body.position.set(0, 0, 0);
scene.add(body);



// 5. Animation
camera.position.z = 5;

const radius = 3;
let wideRotationAngle = 0;


function animateScene()
{
    var x = Math.cos(wideRotationAngle) * radius;
    var z = Math.sin(wideRotationAngle) * radius;
    saucer.position.set(x, 0, z);
    body.position.set(x, 0, z);
    wideRotationAngle += 0.01;

    saucer.rotation.x += 0.01;
    requestAnimationFrame(animateScene)
    renderer.render(scene, camera)
}

animateScene()




// Creating base
// 1. Setting texture
const planeSize = 40;
const loader = new THREE.TextureLoader();
const texture = loader.load('696.jpg');
texture.wrapS = THREE.RepeatWrapping;
texture.wrapT = THREE.RepeatWrapping;
texture.magFilter = THREE.NearestFilter;
texture.colorSpace = THREE.SRGBColorSpace;
const repeats = 40 / 2;
texture.repeat.set(repeats, repeats);

// 2. creating geometry and material
const planeGeo = new THREE.PlaneGeometry(planeSize, planeSize)
const planeMat = new THREE.MeshPhongMaterial({
    map: texture,
    side: THREE.DoubleSide,
});

// 3. Creating mesh
const planeMesh = new THREE.Mesh(planeGeo, planeMat);
planeMesh.rotation.x = Math.PI * -.5;
planeMesh.position.y = -5
scene.add(planeMesh)

// texture.repeat.set(repeats, repeats);


