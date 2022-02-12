package lectures.part1basics

object DefaultArgs extends App {

  def factTailrec(n:Int, a: Int = 1) : Int = {
    if (n<=1) a
    else factTailrec(n-1, n * a)
  }

  val fac = factTailrec(10)
  print(fac)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture(width = 800)

  /*
    1. pass in every leading argument
    2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp")
}
