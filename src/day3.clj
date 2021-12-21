(ns day3
  (:require
    [clojure.string :as string]
    ))

(def day-input
  (->> (slurp "src/day3")
       (string/split-lines)
       (map #(re-seq #"\d" %))))


(defn day3-task-parse-to-int [input]
  (reduce
    (fn [x coll]
      (->> coll
          (map #(Integer/parseInt %))
           (conj x)))
    [] input))



(defn da3-task [input]
  (reduce
    (fn [res coll]
      (if (= coll 0)
       (update res :zero inc)
       (update res :ones inc)))
    {:ones 0 :zero 0} input))



(defn transpose [m]
  (apply mapv vector m))



(defn result-task [input]
  (reduce
    (fn [x coll]
      (->> coll
          (da3-task)
          (conj x)))
    [] input))





(defn x-result [input]
  (->> input
     (day3-task-parse-to-int)
     (transpose)
     (result-task)
     (map (fn [{:keys [ones zero]}]
            (if (> ones zero) 1 0)))))

(defn y-result [x-result]
  (if (= x-result 0) 1 0))


(defn result [input]
  (let [x (x-result input )
        y (map y-result x)]
    (*
      (Long/parseLong (string/join x) 2)
      (Long/parseLong (string/join y) 2)
      )))




(comment
  (result day-input )
  (result-task (transpose (day3-task-parse-to-int day-input)))

  (map (fn [{:keys [ones zeroes ]}]
         (if (> zeroes ones) 1 0)) {:ones 510, :zeroes 490})

(vals {:ones 510, :zero 490})


(read-string \1  )
(result-task [[1 0 1 0 1 1 0 0 0 0 0 1] [1 0 1 0 1 1 0 0 0 0 0 1] [1 0 1 0 1 1 0 0 0 0 0 1]])
(first [1 0 1 0 1 1 0 0 0 0 0 1])
(into [] [1 0 1 0 1 1 0 0 0 0 0 1])
(map #(Integer/parseInt %) ["1" "0" "1" "0" "1" "1" "0" "0" "0" "0" "0" "1"])

(conj [] (vec (re-seq #"\d" "111110001100")))
(day3-task  '("1" "0" "1" "0" "1" "1" "0" "0" "0" "0" "0" "1"))

(day3-task  day-input )

(re-find matcher-num)

(first (re-seq  #"\d" 111110001100))
(re-pattern )
(string/split "111110001100" #"\d+")

  (mapv (fn [str-num]
          (Integer/parseInt str-num)))
(reduce)
  (next day-input )

(map (inc (val :x)) {:x 1 :y 2 :z 3})

(conj []  (vec '(1 0 1 0 1 1 0 0 0 0 0 1)))

(first '(\1 \0 \1 \0 \1 \1 \0 \0 \0 \0 \0 \1))

(into {:x 0 :y 0} {:x 1})

  (Long/parseLong (string/join '(0 1 0 0 1)) 2 )





  )
