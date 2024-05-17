<?php

require_once("task2_describable.php");

abstract class AbstractVechicle {

    public abstract function setModel($model);
    public abstract function getModel();

    public abstract function setCreationYear($creationYear);
    public abstract function getCreationYear();

    public abstract function setImage($imageLink);
    public abstract function getImage();
}

class Vechicle extends AbstractVechicle implements Describable {

    private $model = "";
    private $creationYear = 0;
    private $imageURL = "images/";

    public function  __construct($m, $c, $i) {
        $this->setModel($m);
        $this->setCreationYear($c);
        $this->setImage($i);
    }

    public function getModel()
    {
        return $this->model;
    }
    public function setModel($m)
    {
        $this->model=$m;
    }

    public function getCreationYear()
    {
        return $this->creationYear;
    }
    public function setCreationYear($c)
    {
        $this->creationYear=$c;
    }

    public function getImage()
    {
        return $this->imageURL;
    }
    public function setImage($i)
    {
        $this->imageURL=$i;
    } 

    public function getHeader2() {
        return $this->getModel();
    }
    public function getHeader3() {
        return "Year of production: ".$this->getCreationYear();
    }
}

class Bicycle extends Vechicle {

    private $gearCount = 1;

    public function getGearCount()
    {
        return $this->gearCount;
    }
    public function setGearCount($g)
    {
        $this->gearCount=$g;
    } 

    public function __construct($m,$c,$i,$g)
    {
        parent::__construct($m,$c,$i);
        $this->setGearCount($g);
    }

    public function getHeader3() {
        return parent::getHeader3()." with ".$this->getGearCount()." gears";
    }
}

class Truck extends Vechicle {

    private $tonnage = 1;

    public function getTonnage()
    {
        return $this->tonnage;
    }
    public function setTonnage($t)
    {
        $this->tonnage=$t;
    } 

    public function __construct($m,$c,$i,$t)
    {
        parent::__construct($m,$c,$i);
        $this->setTonnage($t);
    }

    public function getHeader3() {
        return parent::getHeader3()." with ".$this->getTonnage()." tonnage";
    }

}

class Motorboat extends Vechicle {

    private $length = 4;

    public function getLength()
    {
        return $this->length;
    }
    public function setLength($l)
    {
        $this->length=$l;
    } 

    public function __construct($m,$c,$i,$l)
    {
        parent::__construct($m,$c,$i);
        $this->setLength($l);
    }

    public function getHeader3() {
        return parent::getHeader3().", and is ".$this->getLength()." meters long";
    }

}


?>