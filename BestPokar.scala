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
    val rJ=new Rank("J")
    val rQ=new Rank("Q")
    val rK=new Rank("K")
    val rA=new Rank("A")

    ///////RankSequence Array////////////
    var rankSequence= new Array[Rank](13)
    rankSequence(0)=rA
    rankSequence(1)=r2
    rankSequence(2)=r3
    rankSequence(3)=r4
    rankSequence(4)=r5
    rankSequence(5)=r6
    rankSequence(6)=r7
    rankSequence(7)=r8
    rankSequence(8)=r9
    rankSequence(9)=rJ
    rankSequence(10)=rQ
    rankSequence(11)=rK
    rankSequence(12)=rA


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

    var arr=new Array[String](5)
    arr(0)=i1.cardRank.rank
    arr(1)=i2.cardRank.rank
    arr(2)=i3.cardRank.rank
    arr(3)=i4.cardRank.rank
    arr(4)=i5.cardRank.rank





  }

}