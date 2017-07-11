


object PokerHand {
  def main(args: Array[String]): Unit = {
 //Suits:S,D,H,C
 //1/A,2,3,4,5,6,7,8,9,10,J,Q,K
    case class Card(suite:String,rank:Int)
    val hand:List[String]=List("8","10","9","J","A")
   val a=Array[Int](1,2,3,4)
  println(a(2))
  
  val ar=fun1(hand)
 //for(i<-0 to 4){println(ar(i))}
  println("ar"+ar.distinct)
  
 isSequence(ar) 
  
  }
 
def fun1(l:List[String]):List[Int]={
   // var tmpLs=List[Int](5)
    val temparr:Array[String]=Array("*","A","2","3","4","5","6","7","8","9","10","J","Q","K")
   var intLs=List[Int]()
    for(i<- 0 to 4){
      var arrInt=temparr.indexOf(l(i))
   println(arrInt)
      intLs=arrInt::(intLs)
    }
      println("fun1"+intLs)
    intLs.sorted
   
  }

def isSequence(la:List[Int]){
 var l=la
  val lDistinct:List[Int]=l.distinct

  if(lDistinct.length==5) {
  
    if(l.contains(10) && l.contains(1)) 
    
    l.sorted
    
    //final sorted List of Ranks
    println("final sorted list"+l)
    
  }
  else{
    
     println( "Not_IN_SEQ")
  }

}


}