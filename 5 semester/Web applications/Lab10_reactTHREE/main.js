import * as THREE from 'three';
// import * as THREE from './node_modules/three/build/three.module.js';
import {OrbitControls} from 'three/addons/controls/OrbitControls.js'
// control scene using mouse

// PARAMETERS
var windowWidth = window.innerWidth
var windowHeight = window.innerHeight
var fieldOfView = 75            // angle view
var aspectRatio = window.innerWidth / windowHeight;
var nearPlane = 0.1             // minimal fov
var farPlane = 100              // maximal zoomout

// 1. Create scene
const scene = new THREE.Scene();

// adding light
const color = 0xFFFFFF;
const intensity = 1;
const light = new THREE.DirectionalLight(color, intensity);
light.position.set(-1, 2, 4);
scene.add(light);


// directional light
const directionalColor = 0xFFFFFF;
const directionalIntensity = 1.5;
const directionalLight = new THREE.DirectionalLight(directionalColor, directionalIntensity);
directionalLight.position.set(-1,2,4);
scene.add(directionalLight);

// ambient light
const ambientColor = 0xFF000AA;
const ambientIntensity = 1;
const ambientLight = new THREE.AmbientLight(ambientColor, ambientIntensity);
scene.add(ambientLight);

// 2. Create camera
const camera = new THREE.PerspectiveCamera(
    fieldOfView, aspectRatio, nearPlane, farPlane
);

// 3. Crete renderer
const renderer = new THREE.WebGLRenderer();
renderer.setSize(windowWidth,windowHeight);
document.body.appendChild(renderer.domElement);

// 4. Creating objects for drawing

// 4.1 Creating cube
const geometry = new THREE.BoxGeometry(1,2,3); // Geometry
const material = new THREE.MeshBasicMaterial({color: 0xffffff, wireframe: true}); // Material
const cube = new THREE.Mesh(geometry, material); // Geometry + material
// here you can add a single cube: scene.add(cube);

// 4.2 Creating multiple cubes
function getRandomValue(minValue, maxValue){
    return Math.floor(Math.random() * (maxValue - minValue + 1))+minValue;
}

function createCubeAttributes(){
    var minValue = -2;
    var maxValue = 2;
    var randomColor = Math.floor(Math.random()*16777215);
    const cubeAttributes= {
        width: getRandomValue(minValue, maxValue)/2,
        height: getRandomValue(minValue, maxValue)/2,
        depth: getRandomValue(minValue, maxValue)/2,
        color: randomColor,
        position:{
            x: getRandomValue(minValue,maxValue),
            y: getRandomValue(minValue,maxValue),
            z: getRandomValue(minValue,maxValue)
        }
    }
    return cubeAttributes
}

function createCubes(cubes, numberOfCubes)
{
    for(let i=0; i <numberOfCubes;i++){
        const cubeAttributes = createCubeAttributes()
        const geometry = new THREE.BoxGeometry(
            cubeAttributes.width,
            cubeAttributes.height,
            cubeAttributes.depth
        );
        
        //const material = new THREE.MeshBasicMaterial({color: cubeAttributes.color}); // using color as material
        //const material = new THREE.MeshBasicMaterial({color: cubeAttributes.color, wireframe:true}); // wireframe
        const material = new THREE.MeshPhongMaterial({color: cubeAttributes.color}); // lighting
        
        /*
        const texture = new THREE.TextureLoader().load("wood.png");
        const material = new THREE.MeshPhongMaterial({map: texture, depthTest:true});
        */
        const cube = new THREE.Mesh(geometry, material)
        cube.position.x = cubeAttributes.position.x
        cube.position.y = cubeAttributes.position.y
        cube.position.z = cubeAttributes.position.z
        cubes.push(cube)
    }
}

function addCubesToTheScene(cubes, numberOfCubes, scene) {
    for(let i = 0; i < numberOfCubes; i++) {
        scene.add(cubes[i])
    }
}

var cubes = []
var numberOfCubes = 50
createCubes(cubes,numberOfCubes)
addCubesToTheScene(cubes,numberOfCubes,scene)


// 5. Animation
camera.position.z = 5;
function animateScene()
{
    /* // manipulating single cube
    cube.rotation.x += 0.01;
    cube.rotation.y += 0.01;
    cube.rotation.x += 0.01;
    */
    
    for(let i=0; i<numberOfCubes;i++){

        cubes[i].rotation.x += 0.01;
        cubes[i].rotation.y += 0.01;
        cubes[i].rotation.z += 0.01;
    }

    requestAnimationFrame(animateScene)
    renderer.render(scene, camera)
}
animateScene()

// adding mouse control
const controls = new OrbitControls(camera, renderer.domElement)
controls.target.set(0, 5, 0);


// Creating base
// 1. Setting texture
const planeSize = 40;
const loader = new THREE.TextureLoader();
const texture = loader.load('checker.png');
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


