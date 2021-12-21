(ns day1
  (:require
    [clojure.string :as string]))

(def day-input
  (->> (slurp "src/day1")
       (string/split-lines)
       (mapv (fn [str-num]
               (Integer/parseInt str-num)))))

(defn calc-task-loop-1
  [input]
  (loop [f (first input)
         s (second input)
         coll (drop 1 input)
         cnt 0]
    (if (and f s)
      (recur (first coll)
             (second coll)
             (drop 1 coll)
             (if (> s f)
               (inc cnt)
               cnt))
      cnt)))
(rest day-input )
(calc-task-loop-1 day-input)

(defn calc-task-1
  [input]
  (->> input
       (partition 2 1)
       (filter (fn [[a b]] (> b a)))
       (count)))

(defn calc-task-loop-2
  [input]
  (loop [f (first input)
         s (second input)
         coll (drop 1 input)
         cnt 0]
    (if (and f s)
      (recur (first coll)
             (second coll)
             (drop 1 coll)
             (if (> s f)
               (inc cnt)
               cnt))
      cnt)))

;(defn sum-vec
;  [input]
;  (loop [x (apply + (take 3 input))
;         new-input
;         coll (drop 1 input)
;         ]
;    (if-not x
;      (recur
;        coll
;        (conj (vector (apply + (take 3 coll)))new-input)
;        (drop 1 coll)
;        )
;      new-input)))




(defn sum-vec-v-2
  [input]
  (loop [old-input input
         new-input []
         coll input]
    (if (seq old-input)
      (recur
        coll
        (cons
          (apply +
                 (take 3 coll))
          new-input)
        (drop 1 coll)
        )
      (calc-task-loop-1 (vec (reverse new-input))))))


(comment
  (calc-task-1 day-input)

  (apply + (take 3 day-input))
  (if [] 1 0)

  (->> day-input
       (partition 3 1)
       (map #(apply + %))
       (calc-task-1))


  (conj (vector (apply + (take 3 [7100
                                  7099
                                  7116
                                  7123
                                  7142
                                  7143
                                  7140]))) [])


  (sum-vec-v-2  day-input)
  )