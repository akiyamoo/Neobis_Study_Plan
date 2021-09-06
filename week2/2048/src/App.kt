public class App {
    companion object {
        @JvmStatic fun main() {
            var a : Array<Array<Int>> = Array(4) { Array(4, { 0 }) }
            var check : Array<Array<Int>> = Array(4) { Array(4, { 0 }) }
            for (i in 0..3){
                val aa = readLine()?.split(" ")?.map { it.toInt() }
                for (j in 0..3){
                    a[i][j] = aa?.get(j)!!
                }
            }
            val n : Int? = readLine()?.toInt()
            when(n){
                0 -> {
                    var i = 0
                    var j = 3
                    while (i < 4) {
                        while (j > 0) {
                            if (a[i][j - 1] == 0) {
                                a[i][j - 1] = a[i][j]
                                a[i][j] = 0
                            } // if
                            if (a[i][2] != 0 && a[i][1] == 0) j = 2
                            else if (a[i][3] != 0 && a[i][2] == 0) j = 3
                            else if (a[i][1] != 0 && a[i][0] == 0) j = 1
                            else j--
                        }// for vt1
                        j = 0
                        while (j < 3) {
                            if (a[i][j + 1] == a[i][j] && check[i][j] == 0 && check[i][j + 1] == 0) {
                                a[i][j] += a[i][j + 1]
                                a[i][j + 1] = 0
                                check[i][j + 1] = 0
                                check[i][j] = 1
                            } // if
                            else if (a[i][j + 1] != 0 && a[i][j] == 0) {
                                a[i][j] = a[i][j + 1]
                                a[i][j + 1] = 0
                                if (check[i][j + 1] == 1) {
                                    check[i][j] = 1
                                    check[i][j + 1] = 0
                                }
                            } // if
                            j++
                        } // for vt2
                        j = 3
                        while (j > 0) {
                            if (a[i][j - 1] == 0) {
                                a[i][j - 1] = a[i][j]
                                a[i][j] = 0
                            } // if
                            if (a[i][2] != 0 && a[i][1] == 0) j = 2
                            else if (a[i][3] != 0 && a[i][2] == 0) j = 3
                            else if (a[i][1] != 0 && a[i][0] == 0) j = 1
                            else j--
                        }// for vt1
                        j = 0
                        while (j < 3) {
                            if (a[i][j + 1] == a[i][j] && check[i][j] == 0 && check[i][j + 1] == 0) {
                                a[i][j] += a[i][j + 1]
                                a[i][j + 1] = 0
                                check[i][j + 1] = 0
                                check[i][j] = 1
                            } // if
                            else if (a[i][j + 1] != 0 && a[i][j] == 0) {
                                a[i][j] = a[i][j + 1]
                                a[i][j + 1] = 0
                                if (check[i][j + 1] == 1) {
                                    check[i][j] = 1
                                    check[i][j + 1] = 0
                                }
                            } // if
                            j++
                        } // for vt2
                        i++
                        j = 3
                    } // for vn
                } // case 0

                1 -> {
                    var i = 0
                    var j = 3
                    while (i < 4) {
                        while (j > 0) {
                            if (a[j - 1][i] == 0) {
                                a[j - 1][i] = a[j][i]
                                a[j][i] = 0
                            } // if
                            if (a[2][i] != 0 && a[1][i] == 0) j = 2
                            else if (a[3][i] != 0 && a[2][i] == 0) j = 3
                            else if (a[1][i] != 0 && a[0][i] == 0) j = 1
                            else j--
                        }
                        j = 0
                        while (j < 3) {
                            if (a[j + 1][i] == a[j][i] && check[j][i] == 0 && check[j + 1][i] == 0) {
                                a[j][i] += a[j + 1][i]
                                a[j + 1][i] = 0
                                check[j + 1][i] = 0
                                check[j][i] = 1
                            }
                            else if (a[j + 1][i] != 0 && a[j][i] == 0) {
                                a[j][i] = a[j + 1][i]
                                a[j + 1][i] = 0
                                if (check[j + 1][i] == 1) {
                                    check[j][i] = 1
                                    check[j + 1][i] = 0
                                }
                            }
                            j++
                        }
                        j = 3
                        while (j > 0) {
                            if (a[j - 1][i] == 0) {
                                a[j - 1][i] = a[j][i]
                                a[j][i] = 0
                            } // if
                            if (a[2][i] != 0 && a[1][i] == 0) j = 2
                            else if (a[3][i] != 0 && a[2][i] == 0) j = 3
                            else if (a[1][i] != 0 && a[0][i] == 0) j = 1
                            else j--
                        }
                        j = 0
                        while (j < 3) {
                            if (a[j + 1][i] == a[j][i] && check[j][i] == 0 && check[j + 1][i] == 0) {
                                a[j][i] += a[j + 1][i]
                                a[j + 1][i] = 0
                                check[j + 1][i] = 0
                                check[j][i] = 1
                            }
                            else if (a[j + 1][i] != 0 && a[j][i] == 0) {
                                a[j][i] = a[j + 1][i]
                                a[j + 1][i] = 0
                                if (check[j + 1][i] == 1) {
                                    check[j][i] = 1
                                    check[j + 1][i] = 0
                                }
                            }
                            j++
                        }
                        i++
                        j = 3
                    }
                }

                2 -> {
                    var i = 0
                    var j = 0
                    while (i < 4) {
                        while (j < 3) {
                            if (a[i][j + 1] == 0) {
                                a[i][j + 1] = a[i][j]
                                a[i][j] = 0
                            }
                            if (a[i][1] != 0 && a[i][2] == 0) j = 1
                            else if (a[i][2] != 0 && a[i][3] == 0) j = 2
                            else if (a[i][0] != 0 && a[i][1] == 0) j = 0
                            else j++
                        }
                        j = 3
                        while (j > 0) {
                            if (a[i][j] == a[i][j - 1] && check[i][j] == 0 && check[i][j - 1] == 0) {
                                a[i][j] += a[i][j - 1]
                                a[i][j - 1] = 0
                                check[i][j - 1] = 0
                                check[i][j] = 1
                            }
                            else if (a[i][j] == 0 && a[i][j - 1] != 0) {
                                a[i][j] = a[i][j - 1]
                                a[i][j - 1] = 0
                                if (check[i][j - 1] == 1) {
                                    check[i][j] = 1
                                    check[i][j - 1] = 0
                                }
                            }
                            j--
                        }
                        j = 0
                        while (j < 3) {
                            if (a[i][j + 1] == 0) {
                                a[i][j + 1] = a[i][j]
                                a[i][j] = 0
                            }
                            if (a[i][1] != 0 && a[i][2] == 0) j = 1
                            else if (a[i][2] != 0 && a[i][3] == 0) j = 2
                            else if (a[i][0] != 0 && a[i][1] == 0) j = 0
                            else j++
                        }
                        j = 3
                        while (j > 0) {
                            if (a[i][j] == a[i][j - 1] && check[i][j] == 0 && check[i][j - 1] == 0) {
                                a[i][j] += a[i][j - 1]
                                a[i][j - 1] = 0
                                check[i][j - 1] = 0
                                check[i][j] = 1
                            }
                            else if (a[i][j] == 0 && a[i][j - 1] != 0) {
                                a[i][j] = a[i][j - 1]
                                a[i][j - 1] = 0
                                if (check[i][j - 1] == 1) {
                                    check[i][j] = 1
                                    check[i][j - 1] = 0
                                }
                            }
                            j--
                        }
                        i++
                        j = 0
                    }
                }

                3 -> {
                    var i = 0
                    var j = 0
                    while (i < 4) {
                        while (j < 3) {
                            if (a[j + 1][i] == 0) {
                                a[j + 1][i] = a[j][i]
                                a[j][i] = 0
                            } // if
                            if (a[1][i] != 0 && a[2][i] == 0) j = 1
                            else if (a[2][i] != 0 && a[3][i] == 0) j = 2
                            else if (a[0][i] != 0 && a[1][i] == 0) j = 0
                            else j++
                        }
                        j = 3
                        while (j > 0) {
                            if (a[j][i] == a[j - 1][i] && check[j][i] == 0 && check[j - 1][i] == 0) {
                                a[j][i] += a[j - 1][i]
                                a[j - 1][i] = 0
                                check[j - 1][i] = 0
                                check[j][i] = 1
                            }
                            else if (a[j][i] == 0 && a[j - 1][i] != 0) {
                                a[j][i] = a[j - 1][i]
                                a[j - 1][i] = 0
                                if (check[j - 1][i] == 1) {
                                    check[j][i] = 1
                                    check[j - 1][i] = 0
                                }
                            }
                            j--
                        }
                        j = 0
                        while (j < 3) {
                            if (a[j + 1][i] == 0) {
                                a[j + 1][i] = a[j][i]
                                a[j][i] = 0
                            } // if
                            if (a[1][i] != 0 && a[2][i] == 0) j = 1
                            else if (a[2][i] != 0 && a[3][i] == 0) j = 2
                            else if (a[0][i] != 0 && a[1][i] == 0) j = 0
                            else j++
                        }
                        while (j > 0) {
                            if (a[j][i] == a[j - 1][i] && check[j][i] == 0 && check[j - 1][i] == 0) {
                                a[j][i] += a[j - 1][i]
                                a[j - 1][i] = 0
                                check[j - 1][i] = 0
                                check[j][i] = 1
                            } // if
                            else if (a[j][i] == 0 && a[j - 1][i] != 0) {
                                a[j][i] = a[j - 1][i]
                                a[j - 1][i] = 0
                                if (check[j - 1][i] == 1) {
                                    check[j][i] = 1
                                    check[j - 1][i] = 0
                                }
                            }
                            j--
                        }
                        i++
                        j = 0
                    }
                }
            }
            for (i in a){
                for (j in i){
                    print("$j ")
                }
                println()
            }
        }
    }
}
