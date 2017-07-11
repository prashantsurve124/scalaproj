import scala.util.control.Breaks

/**
  * Created by admin on 6/17/2017.
  */
object BestPokar {
  def main(ar:Array[String])
  {//Pokar Suites
    val d=new Suite("D") ////Diamonds
    val s=new Suite("S") ////Spades
    val h=new Suite("H") ////Heart
    val c=new Suite("C") ////Club

    //pokar Ranks  2 to A (2,3,4,5,6,7,8,9,J,Q,K,A)

    val r2=new Rank("2")
    val r3=new Rank("3")
    val r4=new Rank("4")
    val r5=new Rank("5")
    val r6=new Rank("6")
    val r7=new Rank("7")
    val r8=new Rank("8")
    val r9=new Rank("9")
    val r10=new Rank("10")
    val rJ=new Rank("J")
    val rQ=new Rank("Q")
    val rK=new Rank("K")
    val rA=new Rank("A")


    //card
    val c1=new Card(h,rA)
    val c2=new Card(h,rA)
    val c3=new Card(h,rQ)
    val c4=new Card(h,rQ)
    val c5=new Card(s,rQ)


    println(new Poker().bestHand(c1,c2,c3,c4,c5))
  }

}


class Suite(suiteInput:String)
{
  val suite:String=suiteInput
}
class Rank(rankInput:String)
{
  val rank:String=rankInput
}

class Card(suit:Suite,rank:Rank)
{
  val cardSuite=suit
  val cardRank=rank

}



class Poker
{
  def bestHand(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):String={

    ///Four of Kind

    var fok=fourOfKind(i1,i2,i3,i4,i5)
    println(fok+"----")
    var fh=fullHouse(i1,i2,i3,i4,i5)
    var fl=flush(i1,i2,i3,i4,i5)
    if(fok>=4) "FOUR_OF_KIND" else if(fh==3) "FULL_HOUSE" else if(fl==true) "FLUSH" else if(fok==3)"THREE_OF_KIND" else "HIGH_CARD"

  }

  ///////----------Four of Kind-----------///////
  def fourOfKind(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):Int=
  {
    var fourOfKindCounter=0;
    var arr=new Array[String](5)
    arr(0)=i1.cardRank.rank
    arr(1)=i2.cardRank.rank
    arr(2)=i3.cardRank.rank
    arr(3)=i4.cardRank.rank
    arr(4)=i5.cardRank.rank

       val outer=new Breaks
             outer.breakable {
                                for (i <- 0 until 5) {
                                            fourOfKindCounter=0
                                                for (j <- 0 until 5) {

                                                             if (arr(i) == arr(j)) {
                                                                         fourOfKindCounter +=1
                                                             }
                                                }
                                  if (fourOfKindCounter >= 4) {
                                    println("break")
                                    outer.break
                                  }

                                }
              }
    fourOfKindCounter
  }
  ///////////----------------------------------/////////////////////////

////////-----------------FULL_HOUSE------------/////////////////////
  def fullHouse(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):Int={
    val fhReqRank="A";
    var fullHouseCount=0
    var arr=new Array[String](5)
    arr(0)=i1.cardRank.rank
    arr(1)=i2.cardRank.rank
    arr(2)=i3.cardRank.rank
    arr(3)=i4.cardRank.rank
    arr(4)=i5.cardRank.rank

    for(i<-0 until 5){
      if(arr(i)==fhReqRank){
        fullHouseCount+=1
      }
    }
    fullHouseCount
  }

////////////////////////----------------------////////////////////////////////////

  //////////////////////---------FLUSH-------////////////////////////////////
  def flush(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):Boolean={
      var count=0
    var arr=new Array[String](5)
    arr(0)=i1.cardSuite.suite
    arr(1)=i2.cardSuite.suite
    arr(2)=i3.cardSuite.suite
    arr(3)=i4.cardSuite.suite
    arr(4)=i5.cardSuite.suite
//println(arr(1))
    for(i<-0 until 5){
      if(arr(0).equals(arr(i))) count+=1
    }
    println(count)
    if(count==5) true else false
  }
/////////////////////---------------------------////////////////////

  /////////////////////-----STRAIGHT-------//////////////////////////
  def straight(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card): Unit ={
    val tempRank:List[String]=List("A","2","3","4","5","6","7","8","9","10","J","Q","K","A");
    var arr:List[String]=List(i1.cardRank.rank,i2.cardRank.rank,i3.cardRank.rank,i4.cardRank.rank,i5.cardRank.rank)
   /* arr(0)=i1.cardRank.rank
    arr(1)=i2.cardRank.rank
    arr(2)=i3.cardRank.rank
    arr(3)=i4.cardRank.rank
    arr(4)=i5.cardRank.rank
*/
    
    
    
    




  }
  
  

  
  
  
  
  
  def cardSeq(rank:String):Int =
{
  rank match{
    case "A"=>1
    case "2"=>2
    case "3"=>3
    case "4"=>4
    case "5"=>5
    case "6"=>6
    case "7"=>7
    case "8"=>8
    case "9"=>9
    case "10"=>10
    case "J"=>11
    case "Q"=>12
    case "K"=>13
  }

}

def fun1(l:List[String]):List[Int]={
   // var tmpLs=List[Int](5)
    val temparr:Array[String]=Array("*","A","2","3","4","5","6","7","8","9","10","J","Q","K")
   var intLs=List[Int](4)
    for(i<- 0 to 4){
      val arrInt=temparr.indexOf(l(i))
   println(arrInt)
      intLs=arrInt::(intLs)
    }
    intLs.sorted
   
    
  } 
  
  
}

class Nill()
{
  
}